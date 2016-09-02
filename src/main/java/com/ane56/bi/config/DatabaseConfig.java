package com.ane56.bi.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

@Configuration
@PropertySource({ "classpath:jdbc.properties" })
public class DatabaseConfig {

	@Bean
	public DataSource dataSource(Environment env) {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.pass"));

		int min = Integer.parseInt(env.getProperty("jdbc.min", "10"));
		int max = Integer.parseInt(env.getProperty("jdbc.max", "20"));

		dataSource.setInitialSize(min);
		dataSource.setMinIdle(min);
		dataSource.setMaxActive(max);
		dataSource.setTestOnBorrow(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setValidationQuery("SELECT 1");
		return dataSource;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource, ApplicationContext applicationContext)
			throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setMapUnderscoreToCamelCase(true);
		sqlSessionFactoryBean.setConfiguration(configuration);

		Resource[] resources = applicationContext.getResources("classpath:mybatis/**/*.xml");
		sqlSessionFactoryBean.setMapperLocations(resources);
		sqlSessionFactoryBean.setDataSource(dataSource);

		List<Interceptor> interceptors = new ArrayList<>();
		interceptors.add(new SqlEntityInterceptor());
		MySQLDialect dialect = new MySQLDialect();
		interceptors.add(new SqlQueryInterceptor(dialect));
		interceptors.add(new PaginationInterceptor(dialect));
		sqlSessionFactoryBean.setPlugins(interceptors.toArray(new Interceptor[0]));
		return sqlSessionFactoryBean;
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(SqlSessionFactory sqlSessionFactory) {
		MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
		scannerConfigurer.setSqlSessionFactory(sqlSessionFactory);
		scannerConfigurer.setAnnotationClass(Mapper.class);
		scannerConfigurer.setBasePackage("com.ane56.bi.domain");
		return scannerConfigurer;
	}
}
