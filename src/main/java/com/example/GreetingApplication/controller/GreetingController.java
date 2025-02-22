package com.example.GreetingApplication.controller;

import com.example.GreetingApplication.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public String getGreeting() {
        return "{\"message\": \"" + greetingService.getGreetingMessage() + "\"}";
    }

    @PostMapping
    public String postGreeting(@RequestBody String name) {
        return "{\"message\": \"Hello, " + name + "! Your greeting is created.\"}";
    }

    @PutMapping
    public String putGreeting(@RequestBody String name) {
        return "{\"message\": \"Hello, " + name + "! Your greeting is updated.\"}";
    }

    @DeleteMapping
    public String deleteGreeting() {
        return "{\"message\": \"Greeting deleted successfully.\"}";
    }
}
