package br.com.glauber.circulusplay.dto;

import java.io.Serializable;

import br.com.glauber.circulusplay.domain.Genero;

public class GeneroDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	public GeneroDto() {

	}

	public GeneroDto(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public GeneroDto(Genero obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
