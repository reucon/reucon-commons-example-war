package com.reucon.commons.example.war.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class MainController {
    
    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        
        if(Math.random() > 0.5)
        {
            throw new RuntimeException("sample exception");
        }
        return "Hello";
    }
}
