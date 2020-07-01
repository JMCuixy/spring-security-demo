package com.example.springsecurity.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 1099442418@qq.com
 * @Date 2020-07-01 10:28
 * @Description demo 控制器
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping
    public String index() {
        return "Welcome to Spring Security Demo!";
    }
}
