package com.zsx.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "my-consul-server", fallback = ConsumerHystrix.class)
public interface ConsumerService {

    @GetMapping(value = "/consul/server/{msg}")
    String get(@PathVariable("msg") String msg);
}