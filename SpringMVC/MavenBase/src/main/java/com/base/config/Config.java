
package com.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("com.base.controller")
@EnableWebMvc 
public class Config extends WebMvcConfigurerAdapter {
    
    @Bean  
    public UrlBasedViewResolver setupViewResolver() {  
        UrlBasedViewResolver resolver = new UrlBasedViewResolver(); 
        resolver.setContentType("UTF-8");
        resolver.setContentType("text/html; charset=UTF-8");
        resolver.setPrefix("/WEB-INF/jsp/");  
        resolver.setSuffix(".jsp"); 
        resolver.setViewClass(JstlView.class);  
        return resolver;  
    }  
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("Add resource handlers");
        registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
    }
    
}

