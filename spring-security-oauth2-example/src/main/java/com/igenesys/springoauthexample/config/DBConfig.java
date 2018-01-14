package com.igenesys.springoauthexample.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


@Configuration
@PropertySource({"classpath:db.properties"})
public class DBConfig {

	 @Autowired
	 private Environment env;
	 
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName(this.env.getProperty("db.driver"));
	    driverManagerDataSource.setUrl(this.env.getProperty("db.url"));
	    driverManagerDataSource.setUsername(this.env.getProperty("db.user"));
	    driverManagerDataSource.setPassword(this.env.getProperty("db.password"));
	    return driverManagerDataSource;
	}
	 @Bean
	    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	        jdbcTemplate.setResultsMapCaseInsensitive(true);
	        return jdbcTemplate;
	    }
}
