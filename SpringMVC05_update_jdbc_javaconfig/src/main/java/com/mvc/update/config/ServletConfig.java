package com.mvc.update.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//servlet-context.xml을 java로 바꾸기 
@Configuration  //설정파일임을 알려주기 위한 @ 
@EnableWebMvc //= <annotation-driven>
@ComponentScan("com.mvc.update") //= <context:component-scan base-package="com.mvc.update" />
public class ServletConfig implements WebMvcConfigurer {
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/"); //= <resources mapping="/resources/**" location="/resources/" />
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		String prefix = "/WEB-INF/views/";
		String surfix = ".jsp";
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(prefix);
		resolver.setSuffix(surfix);
		
		return resolver;
	}
}









