package com.example.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Spring Security 的核心功能是 认证 + 授权，和其他所有的 Spring 项目一样，它可以很容易的被扩展以满足定制需求。
 *
 * 认证：HTTP Basic 认证、HTTP Digest 认证、HTTP 表单认证、OpenID 和 LDAP 等。
 * 授权：基于 URL 的 Web 请求授权、RBAC（基于角色的访问控制）、访问控制列表（ACL）等。
 */
@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

}
