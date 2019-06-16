package br.com.glauber.circulusplay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.glauber.circulusplay.domain.FilmeAssistido;

@Repository
public interface FilmeAssistidoDAO extends JpaRepository<FilmeAssistido, Integer> {

}
