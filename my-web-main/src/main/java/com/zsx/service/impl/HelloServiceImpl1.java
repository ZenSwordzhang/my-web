package com.zsx.service.impl;

import com.zsx.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl1 implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("Hello 1");
    }
}
