package com.zenyera.dataprovider.controller;

import com.zenyera.dataprovider.domain.Sample;
import com.zenyera.dataprovider.service.SampleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SampleControllerImpl implements SampleController {

    private static final Logger logger = LoggerFactory.getLogger(SampleControllerImpl.class);

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
        logger.info("Getting sample by id: {}", id);
        return sampleService.getSampleById(id);
    }

    @Override
    public Sample saveSample(Sample sample) {
        logger.info("Saving sample: {}", sample);
        return sampleService.saveSample(sample);
    }

    @Override
    public Sample updateSample(Long id, Sample sample) {
        logger.info("Updating sample by id: {}", id);
        return sampleService.updateSample(id, sample);
    }

    @Override
    public ResponseEntity<Sample> deleteSample(Long id) {
        logger.info("Deleting sample by id: {}", id);
        sampleService.deleteSampleById(id);
        return ResponseEntity.ok().build();
    }
}
