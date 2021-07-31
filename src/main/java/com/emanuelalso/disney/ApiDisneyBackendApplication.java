package com.emanuelalso.disney;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class})
public class ApiDisneyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiDisneyBackendApplication.class, args);
	}

}
