package br.com.glauber.circulusplay.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.glauber.circulusplay.domain.Usuario;
import br.com.glauber.circulusplay.dto.FeedDto;
import br.com.glauber.circulusplay.security.JWTUtil;
import br.com.glauber.circulusplay.service.UsuarioService;

@RestController
@RequestMapping(value="/feed")
public class FeedResource {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<FeedDto> postagensAmigos(HttpServletRequest req, @PathVariable int id) {

		Usuario usuario = procuraUsuarioPorToken(req);
		FeedDto amigoDto = null;
		

		if (usuario != null && usuarioService.verificaAmizade(id, usuario)) {
			Usuario amigo  = usuarioService.find(id); 
			amigoDto =  new FeedDto(amigo);
		}

		return ResponseEntity.ok().body(amigoDto);

	}
	
	private Usuario procuraUsuarioPorToken(HttpServletRequest req) {
		String token = req.getHeader("Authorization").substring(7);

		if (jwtUtil.tokenValido(token)) {
			String email = jwtUtil.getUsername(token);

			return usuarioService.findByEmail(email);
		}

		return null;
	}
	
}
