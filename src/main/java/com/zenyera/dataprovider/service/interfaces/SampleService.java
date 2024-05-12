package com.zenyera.dataprovider.service.interfaces;

import com.zenyera.dataprovider.domain.Sample;

import java.util.List;
import java.util.Optional;

public interface SampleService {

    List<Sample> getAllSamples();

    Optional<Sample> getSampleById(Long id);

    Sample saveSample(Sample sample);

    Sample updateSample(Long id, Sample sample);

    void deleteSampleById(Long id);
}
