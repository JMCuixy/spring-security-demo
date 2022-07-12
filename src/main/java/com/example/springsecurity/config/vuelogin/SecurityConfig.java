package com.example.springsecurity.config.vuelogin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.PrintWriter;

/**
 * @author cxy17@meitu.com
 * @date 2022/7/11 11:41
 * @descption
 */
//@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;
    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(usernamePasswordAuthenticationProvider);
    }


    @Bean
    VueLoginAuthenticationFilter vueLoginAuthenticationFilter() throws Exception {
        VueLoginAuthenticationFilter vueLoginAuthenticationFilter = new VueLoginAuthenticationFilter();
        vueLoginAuthenticationFilter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler);
        vueLoginAuthenticationFilter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);
        vueLoginAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
        vueLoginAuthenticationFilter.setFilterProcessesUrl("/vueLogin");
        return vueLoginAuthenticationFilter;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessHandler((req, resp, authentication) -> {
                            resp.setContentType("application/json;charset=utf-8");
                            PrintWriter out = resp.getWriter();
                            out.write(new ObjectMapper().writeValueAsString("注销成功!"));
                            out.flush();
                            out.close();
                        }
                )
                .permitAll()
                .and()
                .csrf().disable().exceptionHandling();
        http.addFilterAt(vueLoginAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}



