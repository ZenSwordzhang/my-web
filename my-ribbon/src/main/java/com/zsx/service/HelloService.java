package com.zsx.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getError")
    public String getMessage(String msg) {
        return restTemplate.getForObject("http://MY-EUREKA-CLIENT/client/" + msg, String.class);
    }

    public String getError(String msg) {
        return "Failed to get message";
    }
}
