package br.com.glauber.circulusplay.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Genero implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String nome;
	
	@JsonIgnore
	@ManyToMany(mappedBy="generos")
	private List<Filme> filmes = new ArrayList<>();

	public Genero() {
	}

	public Genero(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	@Override
	public String toString() {
		return "Genero [id=" + id + ", nome=" + nome + ", filmes=" + filmes + "]";
	}

}
