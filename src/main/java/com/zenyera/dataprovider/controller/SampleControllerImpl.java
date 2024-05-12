package com.zenyera.dataprovider.controller;

import com.zenyera.dataprovider.domain.Sample;
import com.zenyera.dataprovider.service.SampleServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SampleControllerImpl implements SampleController {

    private final SampleServiceImpl sampleService;

    public SampleControllerImpl(SampleServiceImpl sampleService) {
        this.sampleService = sampleService;
    }

    @Override
    public List<Sample> getSamples() {
        return sampleService.getAllSamples();
    }

    @Override
    public Optional<Sample> getSample(Long id) {
        return sampleService.getSampleById(id);
    }

    @Override
    public Sample saveSample(Sample sample) {
        return sampleService.saveSample(sample);
    }

    @Override
    public Sample updateSample(Long id, Sample sample) {
        return sampleService.updateSample(id, sample);
    }

    @Override
    public ResponseEntity<Sample> deleteSample(Long id) {
        sampleService.deleteSampleById(id);
        return ResponseEntity.ok().build();
    }
}
