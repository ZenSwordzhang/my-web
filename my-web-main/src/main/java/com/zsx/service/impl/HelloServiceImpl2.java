package com.zsx.service.impl;

import com.zsx.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl2 implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("Hello 2");
    }
}
