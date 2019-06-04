package br.com.glauber.circulusplay.domain;

public class Comentario {

	private Integer id;
	private String conteudo;
	private Usuario usuario;
	private Filme filme;
	
	public Comentario() {}

	public Comentario(Integer id, String conteudo, Usuario usuario, Filme filme) {
		this.id = id;
		this.conteudo = conteudo;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}