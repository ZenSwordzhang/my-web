package com.zsx.service;

import org.springframework.stereotype.Component;

@Component
public class ConsumerHystrix implements ConsumerService {

    @Override
    public String get(String message) {
        return "Failed to get message";
    }
}
