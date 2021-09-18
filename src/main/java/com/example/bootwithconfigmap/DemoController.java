package com.example.bootwithconfigmap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@Value("${greeter.message: Inside Code}")
    private String greeterMessageFormat; 

    @GetMapping("/greet")
    public String greet() {
        String prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");
        if (prefix == null) {
            prefix = "Hello!";
        }

        return String.format(greeterMessageFormat, prefix, "Rahul");
    }
    
    @GetMapping("/sample")
    public String sample() {
        return "Sample Call";
    }

}
