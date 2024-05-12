package com.zenyera.dataprovider.controller;

import com.zenyera.dataprovider.domain.Sample;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@RequestMapping("/sample")
public interface SampleController {

    @GetMapping
    List<Sample> getSamples();

    @GetMapping("/{id}")
    Optional<Sample> getSample(@PathVariable Long id);

    @PostMapping
    Sample saveSample(@RequestBody Sample sample);

    @PutMapping("/{id}")
    Sample updateSample(@PathVariable Long id, @RequestBody Sample sample);

    @DeleteMapping("/{id}")
    ResponseEntity deleteSample(@PathVariable Long id);
}
