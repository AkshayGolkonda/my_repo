package com.misc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.misc.dto.DBConfig;

@SpringBootApplication
public class MiscTopicsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiscTopicsDemoApplication.class, args);
	}
	
	@Bean
	@Profile(value="prod")
	public DBConfig getDbConfigProd() {
		return new DBConfig("http://localhost:8080/prod","produser");
	}
	
	@Bean
	@Profile(value="test")
	public DBConfig getDbConfigTest() {
		return new DBConfig("http://localhost:8080/test","testuser");
	}

}
