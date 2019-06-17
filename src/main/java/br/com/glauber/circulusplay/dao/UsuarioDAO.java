package br.com.glauber.circulusplay.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.glauber.circulusplay.domain.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

	Usuario findByEmail(String email);

}
