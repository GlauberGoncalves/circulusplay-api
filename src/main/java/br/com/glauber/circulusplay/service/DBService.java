package br.com.glauber.circulusplay.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.glauber.circulusplay.dao.ComentarioPostagemDAO;
import br.com.glauber.circulusplay.dao.FilmeAssistidoDAO;
import br.com.glauber.circulusplay.dao.FilmeDAO;
import br.com.glauber.circulusplay.dao.GeneroDAO;
import br.com.glauber.circulusplay.dao.PostagemDAO;
import br.com.glauber.circulusplay.dao.UsuarioDAO;
import br.com.glauber.circulusplay.domain.ComentarioFilme;
import br.com.glauber.circulusplay.domain.Filme;
import br.com.glauber.circulusplay.domain.FilmeAssistido;
import br.com.glauber.circulusplay.domain.Genero;
import br.com.glauber.circulusplay.domain.Usuario;
import br.com.glauber.circulusplay.domain.enums.Perfil;
import br.com.glauber.circulusplay.domain.enums.Qualificacao;

@Service
public class DBService {

		
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Autowired
	private GeneroDAO generoDao;
	
	@Autowired
	private FilmeDAO filmeDao;
	
	@Autowired
	private ComentarioPostagemDAO comentarioDao;
	
	@Autowired
	private FilmeAssistidoDAO filmeAssistidoDao;
	
	@Autowired
	private PostagemDAO postagemDao;
	
	
	public void instanciaDbTest() {
		
		Usuario usuario1 = new Usuario();		
		usuario1.setId(null);
		usuario1.setNome("Glauber");
		usuario1.setSobrenome("Gonçalves");
		usuario1.setNascimento(new Date());
		usuario1.setEmail("glauber@gmail.com");
		usuario1.setSenha(new BCryptPasswordEncoder().encode("123456"));
		usuario1.addPerfil(Perfil.ADMIN);

		Usuario usuario2 = new Usuario();		
		usuario2.setId(null);
		usuario2.setNome("Jessica");
		usuario2.setSobrenome("Gonçalves");
		usuario2.setNascimento(new Date());
		usuario2.setEmail("jessica@gmail.com");
		usuario2.setSenha(new BCryptPasswordEncoder().encode("123456"));
		
		
		usuarioDao.save(usuario1);
		usuarioDao.save(usuario2);
		
		Genero genero1 = new Genero(1, "Ação");
		Genero genero2 = new Genero(2, "Comedia");
		
		generoDao.save(genero1);
		generoDao.save(genero2);
				
		Filme filme1 = new Filme();
		filme1.setId(1);
		filme1.setTitulo("Vingadores");
		filme1.setAdulto(false);
		filme1.setDataLancamento(new Date());		
						
		Filme filme2 = new Filme();
		filme2.setId(2);
		filme2.setTitulo("Matrix");
		filme2.setAdulto(false);
		filme2.setDataLancamento(new Date());				
		
		genero1.getFilmes().add(filme1);
		genero2.getFilmes().add(filme2);
		
		filme1.getGeneros().add(genero1);
		filme2.getGeneros().add(genero2);								

		filmeDao.save(Arrays.asList(filme1, filme2));
		
		
		ComentarioFilme comentario1 = new ComentarioFilme();
		comentario1.setId(null);
		comentario1.setConteudo("Filme lindo!");
		comentario1.setFilme(filme1);
		comentario1.setUsuario(usuario1);
		
		ComentarioFilme comentario2 = new ComentarioFilme();
		comentario2.setId(null);
		comentario2.setConteudo("Realmente é lindo s2!!!");
		comentario2.setFilme(filme1);
		comentario2.setUsuario(usuario2);
		
		//comentarioDao.save(Arrays.asList(comentario1, comentario2));
		
		
		
		FilmeAssistido filmeAssistido1 = new FilmeAssistido();
		filmeAssistido1.setId(null);
		filmeAssistido1.setUsuario(usuario1);
		filmeAssistido1.setFilme(filme1);
		filmeAssistido1.setQualificacao(Qualificacao.DIAMANTE);
		//filmeAssistido1.setData(new Date());
		
		filmeAssistidoDao.save(filmeAssistido1);				
		usuario1.getAmigos().add(usuario2);		
		
		usuarioDao.save(Arrays.asList(usuario1, usuario2));		
		
		//Postagem post1 = new Postagem(null, new Date(), "Glauber assistiu ao filme e gostou", filme1, usuario1);
		//Postagem post2 = new Postagem(null, new Date(), "Achei ruim", filme2, usuario1);
		
		//postagemDao.save(Arrays.asList(post1, post2));

	}
		
}
