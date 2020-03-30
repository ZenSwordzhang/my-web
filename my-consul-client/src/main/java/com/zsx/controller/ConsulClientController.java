package com.zsx.controller;

import com.zsx.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consul/consumer/")
public class ConsulClientController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/{msg}")
    public ResponseEntity get(@PathVariable("msg") String msg) {
        return new ResponseEntity(consumerService.get(msg), HttpStatus.OK);
    }
}