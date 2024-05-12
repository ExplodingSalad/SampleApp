package com.zenyera.dataprovider.controller;

import com.zenyera.dataprovider.domain.Sample;
import com.zenyera.dataprovider.repository.SampleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class SampleControllerImplIT {

    public final static String SAMPLES = "/sample";

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private SampleRepository sampleRepository;

    @BeforeEach
    void setUp() {
        sampleRepository.deleteAll();
    }

    @Test
    void shouldCreateSample() {
        // given
        var sample = createSample("miau1", "description1");

        // when
        var response = restTemplate.postForEntity(SAMPLES, sample, String.class);
        var persistedSample = sampleRepository.findAll().stream().findFirst().orElseThrow();

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(persistedSample.getName()).isEqualTo(sample.getName());
    }

    @Test
    void shouldGetAllSamples() {
        // given
        var sample1 = createSample("miau1", "description1");
        var sample2 = createSample("miau2", "description2");
        postSamples(List.of(sample1, sample2));

        // when
        var persistedSamples = sampleRepository.findAll();

        // then
        assertThat(persistedSamples.size()).isEqualTo(2);
    }

    @Test
    void shouldGetSpecificSample() {
        // given
        var sample1 = createSample("miau1", "description1");
        var sample2 = createSample("miau2", "description2");
        postSamples(List.of(sample1, sample2));

        var firstSample = sampleRepository.findAll().stream().findFirst().orElseThrow();

        // when
        var response = restTemplate.getForEntity(SAMPLES + "/" + firstSample.getId(), Sample.class);

        // then
        assertThat(response.getBody().getId()).isEqualTo(firstSample.getId());
    }

    @Test
    void shouldUpdateSample() {
        // given
        var sample = createSample("miau1", "description1");
        postSamples(List.of(sample));

        var firstSample = sampleRepository.findAll().stream().findFirst().orElseThrow();

        // when
        var updatedSample = createSample("miau2", "description2");
        restTemplate.put(SAMPLES + "/" + firstSample.getId(), updatedSample);

        var persistedSample = sampleRepository.findAll();

        // then
        assertThat(persistedSample.size()).isEqualTo(1);
        assertThat(persistedSample.get(0).getName()).isEqualTo(updatedSample.getName());
    }

    @Test
    void shouldCreateNewSampleOnUpdatingInexistingSample() {
        // given
        var sample = createSample("miau1", "description1");
        var inexistingId = 23L;

        // when
        restTemplate.put(SAMPLES + "/" + inexistingId, sample, String.class);

        var persistedSample = sampleRepository.findAll().stream().findAny().orElseThrow();

        // then
        assertThat(persistedSample).isNotNull();
        assertThat(persistedSample.getName()).isEqualTo(sample.getName());
    }

    @Test
    void shouldDeleteSample() {
        // given
        var sample = createSample("miau1", "description1");
        postSamples(List.of(sample));

        var persistedSample = sampleRepository.findAll().stream().findFirst().orElseThrow();

        // when
        // then
        assertDoesNotThrow(() -> {
            restTemplate.delete(SAMPLES + "/" + persistedSample.getId());
        });
    }

    private Sample createSample(String name, String description) {
        var sample = new Sample();

        sample.setName(name);
        sample.setDescription(description);
        sample.setNumber(new Random().nextInt());

        return sample;
    }

    private void postSamples(List<Sample> samples) {
        for (Sample sample : samples) {
           restTemplate.postForEntity(SAMPLES, sample, Sample.class);
        }
    }

}