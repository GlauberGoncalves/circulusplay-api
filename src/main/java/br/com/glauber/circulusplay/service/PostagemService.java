package br.com.glauber.circulusplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.glauber.circulusplay.dao.PostagemDAO;
import br.com.glauber.circulusplay.domain.Filme;
import br.com.glauber.circulusplay.domain.Postagem;
import br.com.glauber.circulusplay.service.exceptions.DataIntegrityException;
import br.com.glauber.circulusplay.service.exceptions.ObjectNotFoundException;

@Service
public class PostagemService {

	@Autowired
	private PostagemDAO dao;
	
	public Postagem find(Integer id) {
		Postagem obj = dao.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Filme.class.getName());
		}
		return obj;
	}

	public Postagem insert(Postagem obj) {
		obj.setId(null);
		return dao.save(obj);
	}
	
	public Postagem update(Postagem obj) {
		this.find(obj.getId());		
		return dao.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			dao.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Postagem que possui produtos");
		}
	}
	
	public List<Postagem> findAll() {
		return dao.findAll();
	}
	
	public Page<Postagem> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return dao.findAll(pageRequest);
	}

	public List<Postagem> findByUsuarioId(Integer idUsuario) {
		return dao.findByUsuarioId(idUsuario);
		
	}
	
}
