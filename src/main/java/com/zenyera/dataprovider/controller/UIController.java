package com.zenyera.dataprovider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {

    @GetMapping(value = "/home")
    public String getHomePage() {
        return "index";
    }

}
