package com.reucon.commons.example.war.config;

import com.reucon.commons.web.filter.InputStreamPreservingRequestFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class ExampleWebApplicationInitializer implements WebApplicationInitializer
{
    @Override
    public void onStartup(ServletContext container)
    {
        container.addFilter("wrapper",  InputStreamPreservingRequestFilter.class);
        
        final AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(ExampleWebConfig.class);
        
        final DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
        final ServletRegistration.Dynamic registration = container.addServlet("dispatcher", dispatcherServlet);
        registration.setMultipartConfig(new MultipartConfigElement(""));
        registration.setLoadOnStartup(1);
        registration.addMapping("/example/*");
        
        // https://java.net/jira/browse/SERVLET_SPEC-50
        applicationContext.register(ExceptionHandlingControllerAdvice.class);
        
    }
}
