package com.ane56.bi.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.ane56.bi.application" })
public class ApplicationConfig {
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}

}
