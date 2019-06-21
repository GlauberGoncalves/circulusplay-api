package br.com.glauber.circulusplay.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.glauber.circulusplay.domain.Filme;
import br.com.glauber.circulusplay.dto.FilmeDto;
import br.com.glauber.circulusplay.dto.FilmeSearchDto;
import br.com.glauber.circulusplay.service.FilmeService;

@RestController
@RequestMapping(value="/filmes")
public class FilmeResource {
	
	@Autowired
	private FilmeService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<FilmeDto>> findAll() {
		List<Filme> lista = service.findAll();	
		List<FilmeDto> listaDto = lista.stream().map(obj -> new FilmeDto(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listaDto);
	}
		
	@RequestMapping(value="/populares",method=RequestMethod.GET)
	public ResponseEntity<List<Filme>> findAllPopulares() {
		List<Filme> lista = service.findPopulares();		 
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(value="/buscar/{nome}",method=RequestMethod.GET)
	public ResponseEntity<List<FilmeSearchDto>> findAllPopulares(@PathVariable String nome) {
		List<Filme> lista = service.findPorNome(nome);
		List<FilmeSearchDto> listaDto = lista.stream().map(obj -> new FilmeSearchDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}	
	
	@Cacheable(value="filme")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Filme> find(@PathVariable Integer id) {
		Filme obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.POST)
	@CacheEvict(value = "filme", allEntries=true)
	public ResponseEntity<Void> insert(@Valid @RequestBody Filme filme) {
		Filme obj = service.insert(filme);
				
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@CacheEvict(value = "filme", allEntries=true)
	public ResponseEntity<Void> update(@Valid @RequestBody Filme filme, @PathVariable Integer id) {		
		service.update(filme);		
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@CacheEvict(value = "filme", allEntries=true)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
