package com.harsh.springmvc.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String Home() {
        return "Home";
    }
    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}
