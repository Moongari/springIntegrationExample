package com.moon.springintregration.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/welcome")
    public String WelComePage(){
        return "Hello to the page";
    }

}
