package com.reucon.commons.example.war.config;

import com.reucon.commons.web.exception.ExceptionReportGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = "com.reucon.commons.example.war")
@EnableWebMvc
public class ExampleWebConfig extends WebMvcConfigurerAdapter
{

    @Bean
    public ExceptionReportGenerator exceptionReportGenerator()
    {
        return new ExceptionReportGenerator();
    }
}
