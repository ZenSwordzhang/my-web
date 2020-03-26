package com.zsx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    public String getMessage(String msg) {
        return restTemplate.getForObject("http://MY-EUREKA-CLIENT/client/" + msg, String.class);
    }
}
