package br.com.glauber.circulusplay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.glauber.circulusplay.dao.UsuarioDAO;
import br.com.glauber.circulusplay.domain.Usuario;
import br.com.glauber.circulusplay.security.UsuarioSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Usuario usuario = usuarioDao.findByEmail(email);
		if(usuario == null) {
			throw new UsernameNotFoundException(email);
		}		
		return new UsuarioSS(usuario.getId(), usuario.getEmail(), usuario.getSenha(), usuario.getPerfils());
	}
}
