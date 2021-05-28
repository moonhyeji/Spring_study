package com.mvc.update.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

//web.xml설정을 java로 
public class WebConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {  //onStratup이라는 메소드는 애플리케이션으로 실행 될때 서블릿 컨테이너에 자동으로 호출

		//applicationConfig 연결 
		AnnotationConfigWebApplicationContext applicationConfig = new AnnotationConfigWebApplicationContext();
		applicationConfig.register(ApplicationConfig.class);		
		
		//listener
		servletContext.addListener(new ContextLoaderListener(applicationConfig));
		
		//servletConfig
		AnnotationConfigWebApplicationContext servletConfig = new AnnotationConfigWebApplicationContext();
		servletConfig.register(ServletConfig.class);
		
		
		//-dispatcherservelt만들어주기 
		ServletRegistration.Dynamic dispatcherServlet = 
				servletContext.addServlet("dispatcherServlet", new DispatcherServlet(servletConfig));
		dispatcherServlet.setLoadOnStartup(1);
		dispatcherServlet.addMapping("*.do");	
		
		//filter
		FilterRegistration.Dynamic filterRegistration = 
				servletContext.addFilter("encodingFilter", new CharacterEncodingFilter("UTF-8",true));
		filterRegistration.addMappingForUrlPatterns(null, true , "/*");
		
		
	}

}

































