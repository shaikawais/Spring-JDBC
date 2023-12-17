package com.spring.jdbc.Spring_JDBC;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dao.StudentDao;
import dao.StudentDaoImlp;

@Configuration
@ComponentScan(basePackages = "dao")
public class Config {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
		dmds.setUsername("root");
		dmds.setPassword("root");
		return dmds;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
	}

//	@Bean("studentDao")
//	public StudentDao getStudentDao() {
//		StudentDaoImlp stDao = new StudentDaoImlp();
//		stDao.setJdbcTemplate(getJdbcTemplate());
//		return stDao;
//	}
}
