package br.com.glauber.circulusplay;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.glauber.circulusplay.dao.ComentarioDAO;
import br.com.glauber.circulusplay.dao.FilmeDAO;
import br.com.glauber.circulusplay.dao.GeneroDAO;
import br.com.glauber.circulusplay.dao.UsuarioDAO;
import br.com.glauber.circulusplay.domain.Comentario;
import br.com.glauber.circulusplay.domain.Filme;
import br.com.glauber.circulusplay.domain.Genero;
import br.com.glauber.circulusplay.domain.Usuario;
import br.com.glauber.circulusplay.response.GeneroListResponse;
import br.com.glauber.circulusplay.service.TheMovieDbService;

@SpringBootApplication
public class CirculusplayApplication implements CommandLineRunner {

	@Autowired
	public UsuarioDAO usuarioDao;
	
	@Autowired
	private FilmeDAO filmeDao;
	
	@Autowired
	private GeneroDAO generoDao;
	
	@Autowired
	private ComentarioDAO comentarioDao;
	
	@Autowired
	TheMovieDbService moviedb;
	
	public static void main(String[] args) {
		SpringApplication.run(CirculusplayApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		GeneroListResponse generoList = moviedb.findAllGeneros();
		List<Genero> generos = generoList.getGeneros();
		
		
		Genero genero1 = new Genero(1, "Comédia");
		Genero genero2 = new Genero(2, "Terror");
		Genero genero3 = new Genero(3, "Suspense");
		Genero genero4 = new Genero(4, "Ação");
		Genero genero5 = generos.get(0);
		
		
		
		generoDao.save(genero1);
		generoDao.save(genero2);
		generoDao.save(genero3);
		generoDao.save(genero4);
		generoDao.save(genero5);
		
		Filme filme1 = new Filme();
		Filme filme2 = new Filme();	
		filme1.setId(1);
		filme1.setTitulo("Vingadores: infinit war");
		filme1.setSinopse("Sem sinopse");
		filme1.setAdulto(false);
		filme1.setVotos(9999);
		filme1.setDataLancamento(new Date());
		filme1.addGenero(genero1);
		genero1.getFilmes().add(filme1);
		
		filme2.setId(2);
		filme2.setTitulo("Vingadores end game");
		filme2.setSinopse("sem sinopse");
		filme2.setAdulto(false);
		filme2.setVotos(9999);
		filme2.setDataLancamento(new Date());
		filme2.addGenero(genero2);
		genero2.getFilmes().add(filme2);
		filme1 = filmeDao.save(filme1);
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

		usuario1 = usuarioDao.save(usuario1);
		
		usuario2.getAmigos().add(usuarioDao.findOne(1));
		
		usuarioDao.save(usuario2);
		
		System.out.println(usuario1);
		
		Comentario comentario1 = new Comentario(null,"Qualquer comentario 1", usuario1, filme1);
		Comentario comentario2 = new Comentario(null,"Qualquer comentario 2", usuario1, filme1);
		
		filme1.getComentarios().add(comentario1);
		filme1.getComentarios().add(comentario2);
		
		filmeDao.save(filme1);
		
		comentarioDao.save(comentario1);
		comentarioDao.save(comentario2);
		
		
	}

}
