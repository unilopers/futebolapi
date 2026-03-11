package com.example.demo.futebolapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@Configuration
public class SecurityConfig {

    @Bean
    public FilterRegistrationBean<ApiKeyAuthFilter> apiKeyFilter() {
        FilterRegistrationBean<ApiKeyAuthFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new ApiKeyAuthFilter());

        registrationBean.addUrlPatterns("/*");

        return registrationBean;
    }
}