package com.example.springsecurity.config;

import com.example.springsecurity.demo.DemoController;
import com.example.springsecurity.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author cxy17@meitu.com
 * @date 2022/7/8 13:43
 * @descption
 */
@Component
@WebFilter(urlPatterns = "/demo")
public class MyDelegatingFilterProxy extends DelegatingFilterProxy {

    @Autowired
    private DemoService demoService;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String hello = demoService.hello();
        System.out.println("2" + hello);
        filterChain.doFilter(request, response);
    }
}
