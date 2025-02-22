package com.example.GreetingApplication.controller;
import com.example.GreetingApplication.model.Greeting;
import com.example.GreetingApplication.service.GreetingService;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
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
    @GetMapping
    public String getGreeting(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        return "{\"message\": \"" + greetingService.getGreetingMessage(firstName, lastName) + "\"}";
    }
    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }
    @GetMapping("/all")
    // a list is use

    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
}
