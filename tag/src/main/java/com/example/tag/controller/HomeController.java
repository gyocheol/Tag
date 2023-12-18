package com.example.tag.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 홈
 */
@Controller
@RequiredArgsConstructor
public class HomeController {
    /**
     * 지도로 넘기기
     * @return
     */
    @RequestMapping(value = "/map")
    public String map() {
        return "map";
    }
}
