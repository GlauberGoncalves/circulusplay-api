package br.com.glauber.circulusplay.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.glauber.circulusplay.domain.Comentario;
import br.com.glauber.circulusplay.service.ComentarioService;

@RestController
@RequestMapping(value="/comentarios")
public class ComentarioResource {
	
	@Autowired
	private ComentarioService service;

	@RequestMapping(value="/{postagemId}", method=RequestMethod.GET)
	public ResponseEntity<List<Comentario>> findByPostagem(@PathVariable int postagemId){
				
		List<Comentario> comentarios = service.findByPostagemId(postagemId);
		
		return ResponseEntity.ok().body(comentarios);
		
	}
	
}
