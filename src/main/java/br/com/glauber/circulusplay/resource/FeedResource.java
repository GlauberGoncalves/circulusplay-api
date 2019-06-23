package br.com.glauber.circulusplay.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.glauber.circulusplay.domain.Usuario;
import br.com.glauber.circulusplay.dto.FeedDto;
import br.com.glauber.circulusplay.security.JWTUtil;
import br.com.glauber.circulusplay.service.FeedService;
import br.com.glauber.circulusplay.service.UsuarioService;

@RestController
@RequestMapping(value="/feed")
public class FeedResource {
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private FeedService feedService;
		
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<FeedDto> postagens(HttpServletRequest req) {

		Usuario usuario = procuraUsuarioPorToken(req);		
		FeedDto feed = null;  
		
		if (usuario != null) {			 
			feed =  new FeedDto(usuario);
			feed.setUsuario(usuario);
			feed.setAmigos(usuario.getAmigos());			
			feed.setPostagens(feedService.findFeed(usuario));
		}
		
		return ResponseEntity.ok().body(feed);		
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
