package com.zsx.controller;

import com.zsx.entity.Greeting;
import com.zsx.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/beans")
    public Map<String, HelloService> getBeans() {
        applicationContext.getBeansOfType(HelloService.class).forEach((k,v)-> {
            v.sayHello();
            System.out.println(v);
        });
        return applicationContext.getBeansOfType(HelloService.class);
    }
}