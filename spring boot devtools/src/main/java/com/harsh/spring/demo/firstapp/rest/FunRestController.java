package com.harsh.spring.demo.firstapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World";
    }
    @GetMapping("/working")
    public String auto() {
        return "Working";
    }
    @GetMapping("/automatic")
    public String automatic() {
        return "automatic";
    }
}
