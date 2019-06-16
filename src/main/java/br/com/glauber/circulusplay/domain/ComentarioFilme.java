package br.com.glauber.circulusplay.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ComentarioFilme extends Comentario {

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;	
	
	public ComentarioFilme(Integer id, String conteudo, Usuario usuario, Filme filme) {
		super(id, conteudo, usuario);
		this.filme = filme;
	}
	
	public ComentarioFilme() {
		
	}
	

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}
