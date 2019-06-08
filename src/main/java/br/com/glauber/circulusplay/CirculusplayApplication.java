package br.com.glauber.circulusplay;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.glauber.circulusplay.dao.FilmeDAO;
import br.com.glauber.circulusplay.dao.GeneroDAO;
import br.com.glauber.circulusplay.dao.UsuarioDAO;
import br.com.glauber.circulusplay.domain.Filme;
import br.com.glauber.circulusplay.domain.Genero;
import br.com.glauber.circulusplay.domain.Usuario;
import br.com.glauber.circulusplay.service.UsuarioService;

@SpringBootApplication
public class CirculusplayApplication implements CommandLineRunner {

	@Autowired
	public UsuarioDAO usuarioDao;
	
	@Autowired
	private FilmeDAO filmeDao;
	
	@Autowired
	private GeneroDAO generoDao;
	
	public static void main(String[] args) {
		SpringApplication.run(CirculusplayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Genero genero1 = new Genero(null, "Comédia");
		Genero genero2 = new Genero(null, "Terror");
		Genero genero3 = new Genero(null, "Suspense");
		Genero genero4 = new Genero(null, "Ação");
		
		generoDao.save(genero1);
		generoDao.save(genero2);
		generoDao.save(genero3);
		generoDao.save(genero4);
		
		Filme filme1 = new Filme();
		Filme filme2 = new Filme();	
		filme1.setId(null);
		filme1.setTitulo("Vingadores: infinit war");
		filme1.setSinopse("Sem sinopse");
		filme1.setAdulto(false);
		filme1.setVotos(9999);
		filme1.setDataLancamento(new Date());
		filme1.addGenero(genero1);
		genero1.getFilmes().add(filme1);
		
		filme2.setId(null);
		filme2.setTitulo("Vingadores end game");
		filme2.setSinopse("sem sinopse");
		filme2.setAdulto(false);
		filme2.setVotos(9999);
		filme2.setDataLancamento(new Date());
		filme2.addGenero(genero2);
		genero2.getFilmes().add(filme2);
		filmeDao.save(filme1);
		filmeDao.save(filme2);		
		
		Usuario usuario1 = new Usuario();
		Usuario usuario2 = new Usuario();		
		usuario1.setId(null);
		usuario1.setNome("Glauber");
		usuario1.setNascimento(new Date());
		usuario1.setEmail("glauber@gmail.com");
		usuario1.setSenha("123456");
		usuario1.getFavoritos().add(filme1);
		usuario1.getNãoGostei().add(filme2);		
		
		usuario2.setId(null);
		usuario2.setNome("Jessica");
		usuario2.setNascimento(new Date());
		usuario2.setEmail("jessica@gmail.com");
		usuario2.setSenha("123456");

		usuarioDao.save(usuario1);
		
		usuario2.getAmigos().add(usuarioDao.findOne(1));
		
		usuarioDao.save(usuario2);
		
		
	}

}
