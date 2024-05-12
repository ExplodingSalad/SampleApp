package com.zenyera.dataprovider.service;

import com.zenyera.dataprovider.domain.Sample;
import com.zenyera.dataprovider.repository.SampleRepository;
import com.zenyera.dataprovider.service.interfaces.SampleService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SampleServiceImpl implements SampleService {

    private final SampleRepository sampleRepository;

    public SampleServiceImpl(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public List<Sample> getAllSamples() {
        return sampleRepository.findAll();
    }

    @Override
    public Optional<Sample> getSampleById(Long id) {
        return sampleRepository.findById(id);
    }

    @Override
    public Sample saveSample(Sample sample) {
        return sampleRepository.save(sample);
    }

    @Override
    public Sample updateSample(Long id, Sample sample) {
        var entityFromDb = sampleRepository.findById(id).orElse(new Sample());

        // ideally we'd use mapstruct to map the fields but for showcasing this should suffice..
        entityFromDb = sample;
        entityFromDb.setId(id);     // only sets id for existing entity, if entity is new it will auto increment based on previous value

        return sampleRepository.save(entityFromDb);
    }

    @Override
    public void deleteSampleById(Long id) {
        sampleRepository.deleteById(id);
    }
}
