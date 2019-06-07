package br.com.glauber.circulusplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.glauber.circulusplay.dao.GeneroDAO;
import br.com.glauber.circulusplay.domain.Filme;
import br.com.glauber.circulusplay.domain.Genero;
import br.com.glauber.circulusplay.service.exceptions.DataIntegrityException;
import br.com.glauber.circulusplay.service.exceptions.ObjectNotFoundException;

@Service
public class GeneroService {
	
	@Autowired
	private GeneroDAO dao;
	
	public Genero find(Integer id) {
		Genero obj = dao.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Filme.class.getName());
		}
		return obj;
	}

	public Genero insert(Genero obj) {
		obj.setId(null);
		return dao.save(obj);
	}
	
	public Genero update(Genero obj) {
		find(obj.getId());		
		return dao.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			dao.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Genero que possui produtos");
		}
	}
	
	public List<Genero> findAll() {
		return dao.findAll();
	}
	
	public Page<Genero> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return dao.findAll(pageRequest);
	}	
}
