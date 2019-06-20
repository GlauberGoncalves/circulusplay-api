package br.com.glauber.circulusplay.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.glauber.circulusplay.domain.Postagem;
import br.com.glauber.circulusplay.domain.Usuario;
import br.com.glauber.circulusplay.dto.PostagemDto;
import br.com.glauber.circulusplay.dto.UsuarioDto;
import br.com.glauber.circulusplay.service.PostagemService;
import br.com.glauber.circulusplay.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private PostagemService postagemService;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDto> find(@PathVariable Integer id) {		
		Usuario usuario = service.find(id);
		UsuarioDto obj = new UsuarioDto(usuario);		
		return ResponseEntity.ok().body(obj);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{idUsuario}/postagens", method = RequestMethod.GET)
	public ResponseEntity<List<PostagemDto> > getPostagens(@PathVariable Integer idUsuario) {		
		
		List<Postagem> postagens = postagemService.findByUsuarioId(idUsuario);
		List<PostagemDto> lista = postagens.stream().map( PostagemDto::new ).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(lista);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Usuario usuario) {
		Usuario obj = service.insert(usuario);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody Usuario usuario, @PathVariable Integer id) {
		service.update(usuario);		
		return ResponseEntity.noContent().build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
