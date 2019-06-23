package br.com.glauber.circulusplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.glauber.circulusplay.dao.FilmeDAO;
import br.com.glauber.circulusplay.domain.Filme;
import br.com.glauber.circulusplay.response.FilmeResponse;
import br.com.glauber.circulusplay.service.exceptions.DataIntegrityException;
import br.com.glauber.circulusplay.service.exceptions.ObjectNotFoundException;

@Service
public class FilmeService {

	@Autowired
	private FilmeDAO dao;	
	
	@Autowired
	private TheMovieDbService movieDb;
	
	public Filme find(Integer id) {
		Filme obj = dao.findOne(id);
		if (obj == null) {
			
			FilmeResponse filmeResponse = movieDb.findFilmeById(id);
			obj = filmeResponse.geraFilme();			
			
			if(obj == null) {				
				throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
						+ ", Tipo: " + Filme.class.getName());
			}
		}
		
		//obj.getGeneros().stream().map(genero -> generoDao.save(genero));				
		dao.save(obj);
		return obj;
	}

	public Filme insert(Filme obj) {
		//obj.setId(null);
		return dao.save(obj);
	}
	
	public Filme update(Filme obj) {
		find(obj.getId());		
		return dao.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			dao.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Filme que possui produtos");
		}
	}
	
	public List<Filme> findAll() {
		return dao.findAll();
	}
	
	public List<Filme> findPopulares(){
		return movieDb.findFilmesPopulares();
	}
	
	public List<Filme> findPorNome(String nome){
		return movieDb.findFilmePorNome(nome);
	}
	
	public Page<Filme> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return dao.findAll(pageRequest);
	}
	
}
