package br.com.glauber.circulusplay.dto;

import java.io.Serializable;

import br.com.glauber.circulusplay.domain.Filme;

public class FilmeSearchDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	private String sinopse;
	private Boolean adulto;
	private String imagemFundo;
	private String imagemPoster;

	public FilmeSearchDto() {
		
	}
	
	public FilmeSearchDto(Filme filme) {
		
		id = filme.getId();
		titulo = filme.getTitulo();
		sinopse = filme.getSinopse();
		adulto = filme.getAdulto();
		imagemFundo = filme.getImagemFundo();
		imagemPoster = filme.getImagemFundo();		
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Boolean getAdulto() {
		return adulto;
	}

	public void setAdulto(Boolean adulto) {
		this.adulto = adulto;
	}

	public String getImagemFundo() {
		return imagemFundo;
	}

	public void setImagemFundo(String imagemFundo) {
		this.imagemFundo = imagemFundo;
	}

	public String getImagemPoster() {
		return imagemPoster;
	}

	public void setImagemPoster(String imagemPoster) {
		this.imagemPoster = imagemPoster;
	}

}
