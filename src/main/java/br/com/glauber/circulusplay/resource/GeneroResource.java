package br.com.glauber.circulusplay.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.glauber.circulusplay.domain.Genero;
import br.com.glauber.circulusplay.dto.GeneroDto;
import br.com.glauber.circulusplay.service.GeneroService;

@RestController
@RequestMapping(value="/generos")
public class GeneroResource {

	@Autowired
	private GeneroService service;

	@RequestMapping(method=RequestMethod.GET)
	@Cacheable(value="generos")
	public ResponseEntity<List<GeneroDto>> findAll() {
		List<GeneroDto> lista = service.findAll().stream().map(obj -> new GeneroDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(lista);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	@Cacheable(value="genero")
	public ResponseEntity<Genero> find(@PathVariable Integer id) {
		Genero obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.POST)
	@CacheEvict(value="generos" , allEntries=true)	
	public ResponseEntity<Void> insert(@Valid @RequestBody Genero genero) {
		Genero obj = service.insert(genero);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@CacheEvict(value="generos" , allEntries=true)
	public ResponseEntity<Void> update(@Valid @RequestBody Genero Genero, @PathVariable Integer id) {
		service.update(Genero);
		return ResponseEntity.noContent().build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	@CacheEvict(value="generos" , allEntries=true)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
