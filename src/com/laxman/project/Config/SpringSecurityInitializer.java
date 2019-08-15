package com.laxman.project.Config;

import org.springframework.context.annotation.Bean;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//This is SpringSecurityFilterChain

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}
