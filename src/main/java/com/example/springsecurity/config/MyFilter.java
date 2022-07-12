package com.example.springsecurity.config;

import com.example.springsecurity.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.xml.transform.Source;
import java.io.IOException;

/**
 * @author cxy17@meitu.com
 * @date 2022/7/7 20:53
 * @descption
 */
@Component
@WebFilter(urlPatterns = "/demo")
public class MyFilter implements Filter {

    @Autowired
    private DemoService demoService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String hello = demoService.hello();
        System.out.println("1" + hello);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
