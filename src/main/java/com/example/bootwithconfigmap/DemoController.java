package com.example.bootwithconfigmap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {
	
	@Value("${greeter.message: Inside Code}")
    private String greeterMessageFormat;
	
	@Autowired
    private DemoConfig config;
	
	@Autowired
	RestTemplate resttemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;

    @GetMapping("/greet")
    public String greet() {
        String prefix = System.getenv().getOrDefault("GREETING_PREFIX", "Hi");
        if (prefix == null) {
            prefix = "Hello!";
        }
        return String.format(greeterMessageFormat+" " + prefix +" "+ "Rahul");
    }
    
    @GetMapping("/sample")
    public String sample() {
        return "Sample Call";
    }
    
    @GetMapping
    public String load() {
        return String.format(config.getMessage(), "", "");
    }
    
    @GetMapping("/discover")
    public String discover() {
    	String url="http://springapptarget:8081/target";
    	ResponseEntity<String> responseentity=resttemplate.getForEntity(url, String.class);    	
        return responseentity.getBody();
    }

}
