package br.com.glauber.circulusplay.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Filme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String titulo;

	@Column(length = 4000)
	private String sinopse;

	private Boolean adulto;
	private String imagemFundo;
	private String imagemPoster;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataLancamento;
	private Double votos;
	
	@ManyToMany
	@JoinTable(name = "FILME_GENERO", joinColumns = @JoinColumn(name = "filme_id"), inverseJoinColumns = @JoinColumn(name = "genero_id"))
	private List<Genero> generos = new ArrayList<>();

	@OneToMany(mappedBy = "filme")
	private List<ComentarioFilme> comentarios = new ArrayList<>();

	public Filme() {
	}

	public Filme(Integer id, String titulo, String sinopse, Boolean adulto, String imagemFundo, String imagemPoster,
			Date dataLancamento, Double votos) {
		this.id = id;
		this.titulo = titulo;
		this.sinopse = sinopse;
		this.adulto = adulto;
		this.imagemFundo = imagemFundo;
		this.imagemPoster = imagemPoster;
		this.dataLancamento = dataLancamento;
		this.votos = votos;
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

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	public void addGenero(Genero genero) {
		if (genero != null) {
			this.generos.add(genero);
		}
	}

	public List<ComentarioFilme> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioFilme> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Filme [id=" + id + ", titulo=" + titulo + ", sinopse=" + sinopse + ", adulto=" + adulto
				+ ", imagemFundo=" + imagemFundo + ", imagemPoster=" + imagemPoster + ", dataLancamento="
				+ dataLancamento + ", votos=" + votos + ", generos=" + generos + ", comentarios=" + comentarios + "]";
	}


	
	
}
