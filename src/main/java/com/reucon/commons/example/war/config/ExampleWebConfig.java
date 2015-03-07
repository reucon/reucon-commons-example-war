package com.reucon.commons.example.war.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = "com.reucon.commons.example.war")
@EnableWebMvc
public class ExampleWebConfig extends WebMvcConfigurerAdapter {
}
