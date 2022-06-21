package com.example;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.example.model.MyDataSource;
import com.example.model.Student;

@Configuration
public class SpringConfiguration {

	@Bean
	public DataSource getDataSource() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/sample";
		String username = "vmdubey";
		String pass = "admin";
		DataSource source = new MyDataSource(driver, url, username, pass);

		return source;
	}

	@Bean
	public JdbcTemplate getTemplate(DataSource dataSource) {
		JdbcTemplate temp = new JdbcTemplate(dataSource);
		return temp;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory(DataSource source) {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(source);
		factoryBean.setAnnotatedClasses(Student.class);
		factoryBean.setPackagesToScan("com.example.model");
		factoryBean.setHibernateProperties(getProperties());

		return factoryBean;
	}

	public Properties getProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.hbm2ddl.auto", "update");

		props.setProperty("spring.jpa.hibernate.use-new-id-generator-mappings", "false");
		props.setProperty("hibernate.show_sql", "true");

		return props;
	}

}
