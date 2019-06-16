package br.com.glauber.circulusplay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.glauber.circulusplay.domain.Postagem;

public interface PostagemDAO extends JpaRepository<Postagem, Integer> {

	List<Postagem> findByUsuarioId(Integer idUsuario);

}