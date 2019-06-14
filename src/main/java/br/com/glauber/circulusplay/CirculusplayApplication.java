package br.com.glauber.circulusplay;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.glauber.circulusplay.dao.GeneroDAO;
import br.com.glauber.circulusplay.dao.UsuarioDAO;
import br.com.glauber.circulusplay.domain.Genero;
import br.com.glauber.circulusplay.domain.Usuario;
import br.com.glauber.circulusplay.response.GeneroListResponse;
import br.com.glauber.circulusplay.service.TheMovieDbService;

@SpringBootApplication
public class CirculusplayApplication implements CommandLineRunner {

	@Autowired
	public UsuarioDAO usuarioDao;
	
	@Autowired
	private GeneroDAO generoDao;
	
	@Autowired
	TheMovieDbService moviedb;
	
	public static void main(String[] args) {
		SpringApplication.run(CirculusplayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
			
			GeneroListResponse generoList = moviedb.findAllGeneros();
			List<Genero> generos = generoList.getGeneros();			
			generos.forEach(obj -> generoDao.save(obj));											
		} catch( Exception e) {
			
			throw new Exception("Erro ao acessar api the moviedb e fazer carga no banco local");
		}
		
										
		Usuario usuario1 = new Usuario();		
		usuario1.setId(null);
		usuario1.setNome("Glauber");
		usuario1.setSobrenome("Gonçalves");
		usuario1.setNascimento(new Date());
		usuario1.setEmail("glauber@gmail.com");
		usuario1.setSenha("123456");
		usuarioDao.save(usuario1);
				
	}

}
