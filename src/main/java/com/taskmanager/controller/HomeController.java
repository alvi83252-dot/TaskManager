package com.taskmanager.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "TaskManager API is running";
    }
    
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
