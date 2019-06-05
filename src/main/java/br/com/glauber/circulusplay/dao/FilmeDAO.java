package br.com.glauber.circulusplay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.glauber.circulusplay.domain.Filme;

@Repository
public interface FilmeDAO extends JpaRepository<Filme, Integer> {

}
