package com.ignacio.songapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Song API is successfully running! The API endpoint is located at /ignacio/songs";
    }
}
