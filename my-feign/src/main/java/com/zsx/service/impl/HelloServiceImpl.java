package com.zsx.service.impl;

import com.zsx.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String get(String msg) {
        return "Failed to get message";
    }
}
