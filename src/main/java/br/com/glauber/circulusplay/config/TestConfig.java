package br.com.glauber.circulusplay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.glauber.circulusplay.service.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instanciaBanco() {
		
		dbService.instanciaDbTest();
		return true;
	}
	
}
