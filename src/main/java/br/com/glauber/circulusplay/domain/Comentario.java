package br.com.glauber.circulusplay.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String conteudo;
	// private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;

	public Comentario() {
	}

	public Comentario(Integer id, String conteudo, Usuario usuario, Filme filme) {
		this.id = id;
		this.conteudo = conteudo;
		// this.usuario = usuario;
		this.filme = filme;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

}