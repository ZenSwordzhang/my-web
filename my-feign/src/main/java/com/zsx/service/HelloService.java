package com.zsx.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("my-eureka-client")
public interface HelloService {

    @GetMapping(value = "/client/{msg}")
    String get(@PathVariable("msg") String msg);
}
