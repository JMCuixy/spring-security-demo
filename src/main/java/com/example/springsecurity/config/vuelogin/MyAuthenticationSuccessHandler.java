package com.example.springsecurity.config.vuelogin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * @author cxy17@meitu.com
 * @date 2022/7/11 11:39
 * @descption
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        Object principal = authentication.getPrincipal();
        float initialCapacity = 3 / 0.75F + 1.0F;
        HashMap<String, Object> respMap = new HashMap<>((int) initialCapacity);
        respMap.put("code", 200);
        respMap.put("message", "success");
        respMap.put("data", principal);
        String s = new ObjectMapper().writeValueAsString(respMap);
        out.write(s);
        out.flush();
        out.close();
    }
}


