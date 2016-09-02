package com.ane56.bi.config;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.ane56.bi.application" })
public class ApplicationConfig {
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}

}
