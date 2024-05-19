package com.zenyera.dataprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrashController {

    @GetMapping("/crash")
    public void crash() {
        throw new RuntimeException("Forced application crash");
    }

}