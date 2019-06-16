package br.com.glauber.circulusplay.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;

	private String conteudo;
	
	@CreationTimestamp
	private Date criadoEm;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Comentario() {
	}

	public Comentario(Integer id, String conteudo, Usuario usuario) {
		this.id = id;
		this.conteudo = conteudo;
		this.usuario = usuario;		
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

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", conteudo=" + conteudo + ", criadoEm=" + criadoEm + ", usuario=" + usuario
				+ "]";
	}
	
	

}