package com.example.GreetingApplication.service;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import com.example.GreetingApplication.model.Greeting;
import com.example.GreetingApplication.repository.GreetingRepository;

@Service

public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String getGreetingMessage(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello World!";
        }
        Greeting greeting = new Greeting(message);
        greetingRepository.save(greeting);
        return message;
    }

    public Optional<Greeting> getGreetingById(Long id) {
        return greetingRepository.findById(id);
    }
    //avinasjh
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
}
