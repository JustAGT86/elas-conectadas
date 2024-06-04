package com.joao.os.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.joao.os.services.DBService;



@Configuration
@Profile("dev")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;

	@Bean
	public boolean instanceDB() {
		
		if(ddl.equals("create")) {
			this.dbService.instanciaDB();
		}
		
		return false;
		
	}
}
