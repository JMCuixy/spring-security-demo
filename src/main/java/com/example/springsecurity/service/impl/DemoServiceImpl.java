package com.example.springsecurity.service.impl;

import com.example.springsecurity.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @author cxy17@meitu.com
 * @date 2022/7/8 13:55
 * @descption
 */
@Service
public class DemoServiceImpl implements DemoService {


    @Override
    public String hello() {
        return "world";
    }
}
