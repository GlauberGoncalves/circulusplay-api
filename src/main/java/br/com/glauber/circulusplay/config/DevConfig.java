package br.com.glauber.circulusplay.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.glauber.circulusplay.dao.GeneroDAO;
import br.com.glauber.circulusplay.domain.Genero;
import br.com.glauber.circulusplay.response.GeneroListResponse;
import br.com.glauber.circulusplay.service.DBService;
import br.com.glauber.circulusplay.service.TheMovieDbService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private TheMovieDbService moviedb;
	
	@Autowired
	private GeneroDAO generoDao;
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public Boolean instanciaCategoriasDoTheMovieDbApi() {
		
		try {			
			GeneroListResponse generoList = moviedb.findAllGeneros();
			List<Genero> generos = generoList.getGeneros();			
			generos.forEach(obj -> generoDao.save(obj));
			dbService.instanciaDbTest();
			
		} catch( Exception e) {		
			throw new RuntimeException("Erro ao acessar api the moviedb e fazer carga no banco local");
		}		
		
		return true;
	}
}
