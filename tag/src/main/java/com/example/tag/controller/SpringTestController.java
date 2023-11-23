package com.example.tag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringTestController {

    @RequestMapping("/test")
    public String springTestController() {
        return "test";
    }
}
