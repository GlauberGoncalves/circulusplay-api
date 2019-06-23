package br.com.glauber.circulusplay.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.glauber.circulusplay.dao.UsuarioDAO;
import br.com.glauber.circulusplay.domain.Postagem;
import br.com.glauber.circulusplay.domain.Usuario;

@Service
public class FeedService {
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	public List<Postagem> findFeed(Usuario usuario){
		
		List<Postagem> postagensDoFeed = new ArrayList<>();
		
		usuario.getAmigos().forEach(obj -> {			
			postagensDoFeed.addAll(usuarioDao.findOne(obj.getId()).getPostagens());			
		});
		
		return postagensDoFeed;
	}
	

}
