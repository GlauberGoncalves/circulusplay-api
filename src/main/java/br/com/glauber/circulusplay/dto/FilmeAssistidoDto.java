package br.com.glauber.circulusplay.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.glauber.circulusplay.domain.Filme;
import br.com.glauber.circulusplay.domain.FilmeAssistido;
import br.com.glauber.circulusplay.domain.enums.Qualificacao;

public class FilmeAssistidoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;	
	private FilmeDto filme;
	private Qualificacao qualificacao;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	public FilmeAssistidoDto() {
		
	}

	public FilmeAssistidoDto(FilmeAssistido filme) {
		this.id = filme.getId();		
		this.filme = new FilmeDto(filme.getFilme());
		this.qualificacao = filme.getQualificacao();
		this.data = filme.getData();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FilmeDto getFilme() {
		return filme;
	}

	public void setFilme(FilmeDto filme) {
		this.filme = filme;
	}

	public Qualificacao getQualificacao() {
		return qualificacao;
	}

	public void setQualificacao(Qualificacao qualificacao) {
		this.qualificacao = qualificacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
