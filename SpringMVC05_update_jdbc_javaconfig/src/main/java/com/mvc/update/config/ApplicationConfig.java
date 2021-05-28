package com.mvc.update.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
//얘가 spring bean configration file이라는 것을 알려주기.
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:sqls/db.properties") //= <context:property-placeholder location="classpath:sqls/db.properties"/>
public class ApplicationConfig {
	
	@Value("${oracle.driver}")
	private String driver;
	@Value("${oracle.url}")
	private String url;
	@Value("${oracle.username}")
	private String username;
	@Value("${oracle.password}")
	private String password;

    @Bean	       //bean tag -> bean annotaion
	public DataSource dataSource() {  // bean객체 대신하기위해 만듦. <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName(driver);
    	dataSource.setUrl(url);
    	dataSource.setUsername(username);
    	dataSource.setPassword(password);
    	
    	//그럼 위에 @Value 는 값을 가져오는 거고 아래 datasorce메소드에서 값을 setting
		return dataSource;
	}
    
    @Bean 
    public JdbcTemplate jdbcTemplate() {
    	JdbcTemplate jdbcTemplate = new JdbcTemplate();
    	jdbcTemplate.setDataSource(dataSource());
    	
    	return jdbcTemplate;
    }
    
    
    
    
    
    
}




















