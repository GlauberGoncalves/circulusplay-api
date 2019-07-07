package br.com.glauber.circulusplay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.glauber.circulusplay.domain.Comentario;
import br.com.glauber.circulusplay.domain.ComentarioPostagem;

@Repository
public interface ComentarioPostagemDAO extends JpaRepository<ComentarioPostagem, Integer> {

	List<Comentario> findByPostagemId(int postagem);

}
