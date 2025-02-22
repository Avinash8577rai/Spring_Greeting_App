package com.example.GreetingApplication.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public String getGreeting() {
        return "{\"message\": \"Hello, Welcome to Greeting App!\"}";
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