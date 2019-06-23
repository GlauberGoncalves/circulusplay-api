package br.com.glauber.circulusplay.dto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.glauber.circulusplay.domain.Postagem;
import br.com.glauber.circulusplay.domain.Usuario;

public class FeedDto {

	private UsuarioDto usuario;
	private List<UsuarioDto> amigos;
	private List<PostagemDto> postagens = null;

	public FeedDto(Usuario usuario) {

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

	public void setUsuario(Usuario usuario) {
		this.usuario = new UsuarioDto(usuario);
	}

	public void setAmigos(List<Usuario> amigos) {		
		this.amigos = amigos.stream().map(UsuarioDto::new).collect(Collectors.toList());;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens.stream().map(PostagemDto::new).collect(Collectors.toList());
	}

	public void ordenaPostagens() {
		Comparator<PostagemDto> cmp = new Comparator<PostagemDto>() {

			@Override
			public int compare(PostagemDto o1, PostagemDto o2) {
				if (o1.getInstante().before(o2.getInstante())) {
					return 1;
				} else if (o1.getInstante().after(o2.getInstante())) {
					return -1;
				} else {
					return 0;
				}
			}
		};

		if (this.postagens != null) {
			Collections.sort(this.postagens, cmp);
		}
	}

}
