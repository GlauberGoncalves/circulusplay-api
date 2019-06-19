package br.com.glauber.circulusplay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.glauber.circulusplay.dao.UsuarioDAO;
import br.com.glauber.circulusplay.domain.Usuario;
import br.com.glauber.circulusplay.security.UsuarioSS;
import br.com.glauber.circulusplay.service.exceptions.DataIntegrityException;
import br.com.glauber.circulusplay.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO dao;
	
	public Usuario find(Integer id) {
		Usuario obj = dao.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Usuario.class.getName());
		}
		return obj;
	}

	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return dao.save(obj);
	}
	
	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		return dao.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			dao.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Usuario que possui produtos");
		}
	}
	
	public List<Usuario> findAll() {
		return dao.findAll();
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return dao.findAll(pageRequest);
	}	
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
	}

	public Usuario findByEmail(String email) {
		return dao.findByEmail(email);		
	}
	
	public static UsuarioSS authenticated() {
		try {
			return (UsuarioSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
	
}
