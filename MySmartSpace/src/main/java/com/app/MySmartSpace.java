package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class MySmartSpace {

	public static void main(String[] args) {
		SpringApplication.run(MySmartSpace.class, args);
	}

}
