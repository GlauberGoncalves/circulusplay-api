package br.com.glauber.circulusplay.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.glauber.circulusplay.domain.ComentarioPostagem;
import br.com.glauber.circulusplay.domain.Postagem;
import br.com.glauber.circulusplay.domain.Usuario;

public class PostagemDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm")	
	private Date instante;	
	private String titulo;	
	private FilmeDto filmeAssistido;
	private Usuario postadoPor;
	private List<ComentarioPostagem> comentarios = new ArrayList<>();

	public PostagemDto() {
		
	}
	
	public PostagemDto(Postagem postagem) {
		this.id = postagem.getId();
		this.instante = postagem.getInstante();
		this.titulo = postagem.getTitulo();
		this.filmeAssistido = new FilmeDto(postagem.getFilmeAssistido());
		this.postadoPor = postagem.getPortadoPor();
		this.comentarios = postagem.getComentarios();
	}


	public Integer getId() {
		return id;
	}


	public Date getInstante() {
		return instante;
	}


	public String getTitulo() {
		return titulo;
	}


	public FilmeDto getFilmeAssistido() {
		return filmeAssistido;
	}


	public Usuario getPostadoPor() {
		return postadoPor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<ComentarioPostagem> getComentarios() {
		return comentarios;
	}	
		
	
}
