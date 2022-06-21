package com.example.model;

import org.apache.commons.dbcp.BasicDataSource;

public class MyDataSource extends BasicDataSource {

	public MyDataSource(String driver, String url, String username, String pass) {
		super();
		this.setDriverClassName(driver);
		this.setUrl(url);
		this.setUsername(username);
		this.setPassword(pass);
	}
}
