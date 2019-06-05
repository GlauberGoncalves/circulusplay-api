package br.com.glauber.circulusplay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.glauber.circulusplay.dao.UsuarioDAO;
import br.com.glauber.circulusplay.domain.Usuario;

@SpringBootApplication
public class CirculusplayApplication implements CommandLineRunner {

	@Autowired
	public UsuarioDAO dao;
	
	public static void main(String[] args) {
		SpringApplication.run(CirculusplayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();
		
		usuario1.setId(null);
		usuario1.setNome("Glauber");
		usuario1.setEmail("glauber@gmail.com");
		usuario1.setSenha("123456");
		
		usuario2.setId(null);
		usuario2.setNome("Glauber");
		usuario2.setEmail("glauber@gmail.com");
		usuario2.setSenha("123456");
				
		dao.save(usuario1);
		dao.save(usuario2);
		
	}

}
