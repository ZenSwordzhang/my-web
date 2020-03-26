package com.zsx.service;

import com.zsx.service.impl.HelloServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "my-eureka-client", fallback = HelloServiceImpl.class)
public interface HelloService {

    @GetMapping(value = "/client/{msg}")
    String get(@PathVariable("msg") String msg);
}
