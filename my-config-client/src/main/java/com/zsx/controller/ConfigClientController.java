package com.zsx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/config/client")
public class ConfigClientController {

    @Value("${customize.port}")
    private String port;

    @GetMapping("/{msg}")
    public ResponseEntity get(@PathVariable("msg") String msg) {
        return new ResponseEntity(String.format("The message content is : %s, Service port is : %s", msg, port), HttpStatus.OK);
    }
}
