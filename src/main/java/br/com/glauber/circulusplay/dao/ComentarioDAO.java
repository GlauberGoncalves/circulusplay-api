package br.com.glauber.circulusplay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.glauber.circulusplay.domain.Comentario;

@Repository
public interface ComentarioDAO extends JpaRepository<Comentario, Integer> {

}
