package com.romario.aulao.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.romario.aulao.service.DBService;
import com.romario.aulao.service.EmailService;
import com.romario.aulao.service.MockEmailService;

@Configuration
@Profile("test")
public class TesteConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instatiateDatabase( ) throws ParseException {
	dbService.instantiateTestDatabase();
	return true;	
	}
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
	
}
