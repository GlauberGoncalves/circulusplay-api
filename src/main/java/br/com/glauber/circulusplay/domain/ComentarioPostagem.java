package br.com.glauber.circulusplay.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ComentarioPostagem extends Comentario {

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "postagem_id")
	private Postagem postagem;

	public ComentarioPostagem(Integer id, String conteudo, Usuario usuario, Postagem postagem) {
		super(id, conteudo, usuario);
		this.postagem = postagem;
	}

	public Postagem getPostagem() {
		return postagem;
	}

	public void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}			
	
}
