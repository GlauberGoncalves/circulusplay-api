package br.com.glauber.circulusplay.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.glauber.circulusplay.domain.Usuario;
import br.com.glauber.circulusplay.dto.PostagemDto;
import br.com.glauber.circulusplay.security.JWTUtil;
import br.com.glauber.circulusplay.service.PostagemService;
import br.com.glauber.circulusplay.service.UsuarioService;

@RestController
@RequestMapping(value = "/postagens")
public class PostagemResource {

	@Autowired
	private PostagemService service;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private JWTUtil jwtUtil;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PostagemDto>> minhasPostagens(HttpServletRequest req) {

		Usuario usuario = procuraUsuarioPorToken(req);

		List<PostagemDto> postagens;

		if (usuario != null) {
			postagens = service.findByUsuarioId(usuario.getId()).stream().map(PostagemDto::new)
					.collect(Collectors.toList());
		} else {
			postagens = new ArrayList<>();
		}

		return ResponseEntity.ok().body(postagens);

	}

	@RequestMapping(value = "/amigos/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<PostagemDto>> postagensAmigos(HttpServletRequest req, @PathVariable int id) {

		Usuario usuario = procuraUsuarioPorToken(req);
		List<PostagemDto> postagens = new ArrayList<>();

		if (usuario != null && verificaAmizade(id, usuario)) {
			postagens = service.findByUsuarioId(id).stream().map(PostagemDto::new).collect(Collectors.toList());
		}

		return ResponseEntity.ok().body(postagens);

	}

	private boolean verificaAmizade(int id, Usuario usuario) {
		Usuario usuarioAVisualizar = new Usuario();
		;
		usuarioAVisualizar.setId(id);
		return usuario.getAmigos().contains(usuarioAVisualizar);
	}

	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public ResponseEntity<String> findPerfil() {

		return ResponseEntity.ok().body("teste");
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
