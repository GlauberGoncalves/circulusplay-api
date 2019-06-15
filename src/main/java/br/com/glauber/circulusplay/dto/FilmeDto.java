package br.com.glauber.circulusplay.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.glauber.circulusplay.domain.Filme;

public class FilmeDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	private String sinopse;
	private Boolean adulto;
	private String imagemFundo;
	private String imagemPoster;
	private List<GeneroDto> generos;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataLancamento;
	private Double votos;

	public FilmeDto() {

	}

	public FilmeDto(Filme filme) {
		id = filme.getId();
		titulo = filme.getTitulo();
		sinopse = filme.getSinopse();
		adulto = filme.getAdulto();
		imagemFundo = filme.getImagemFundo();
		imagemPoster = filme.getImagemFundo();
		dataLancamento = filme.getDataLancamento();
		votos = filme.getVotos();
		generos = filme.getGeneros().stream().map(obj -> new GeneroDto(obj.getId(), obj.getNome()))
				.collect(Collectors.toList());
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

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Double getVotos() {
		return votos;
	}

	public void setVotos(Double votos) {
		this.votos = votos;
	}

	public List<GeneroDto> getGeneros() {
		return generos;
	}

	public void setGeneros(List<GeneroDto> generos) {
		this.generos = generos;
	}

}
