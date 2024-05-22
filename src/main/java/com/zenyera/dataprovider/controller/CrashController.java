package com.zenyera.dataprovider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CrashController {

    private static final Logger logger = LoggerFactory.getLogger(SampleControllerImpl.class);

    @GetMapping("/crash")
    public void crash() {
        logger.info("Attempting to forcefully crash the app for showcasing purposes...");
        logger.info("Shutting down...");
        System.exit(1);
        throw new RuntimeException("Forced application crash");
    }

}