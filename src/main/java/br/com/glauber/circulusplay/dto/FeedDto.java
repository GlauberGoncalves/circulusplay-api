package br.com.glauber.circulusplay.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.glauber.circulusplay.domain.Usuario;

public class FeedDto {

	private UsuarioDto usuario;
	private List<UsuarioDto> amigos;
	private List<PostagemDto> postagens;

	public FeedDto(Usuario usuario) {
		this.usuario = new UsuarioDto(usuario);
		this.amigos = usuario.getAmigos().stream().map(obj -> new UsuarioDto(obj)).collect(Collectors.toList());
		this.postagens = usuario.getPostagens().stream().map(PostagemDto::new).collect(Collectors.toList());
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public List<UsuarioDto> getAmigos() {
		return amigos;
	}

	public List<PostagemDto> getPostagens() {
		return postagens;
	}

}
