package com.example.nix_spring1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping(path = "/ping")
    public String pong() {
        return "pong";
    }

}
