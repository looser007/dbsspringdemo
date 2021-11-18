package com.dbs.employeemngts.config;
import javax.sql.DataSource;



import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;



@Configuration
@ComponentScan(basePackages = "com.dbs.employeemngts")
@PropertySource("classpath:application.properties")
public class Config {

@Autowired

private Environment environment;
@Bean("datasource")
@Scope("prototype")
public DataSource getDataSource() {

BasicDataSource basicDataSource=new BasicDataSource();
basicDataSource.setUsername(environment.getProperty("db.username"));
basicDataSource.setPassword(environment.getProperty("db.password"));
basicDataSource.setUrl(environment.getProperty("db.url"));
basicDataSource.setDriverClassName(environment.getProperty("db.classname"));
return basicDataSource;

}
@Bean("jdbcTemplate")
public JdbcTemplate getJDBCTemplate() {

JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
return jdbcTemplate;
}



}