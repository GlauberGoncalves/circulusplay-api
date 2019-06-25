package br.com.glauber.circulusplay.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class NotificacaoAmizade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "amigo_id")
	private Usuario seguirAmigo;
	
	@CreationTimestamp
	private Date instante;
	private Date dataResposta;
	private boolean respostaAmigo;
	
	public NotificacaoAmizade() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getSeguirAmigo() {
		return seguirAmigo;
	}

	public void setSeguirAmigo(Usuario seguirAmigo) {
		this.seguirAmigo = seguirAmigo;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Date getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(Date dataResposta) {
		this.dataResposta = dataResposta;
	}

	public boolean isRespostaAmigo() {
		return respostaAmigo;
	}

	public void setRespostaAmigo(boolean respostaAmigo) {
		this.respostaAmigo = respostaAmigo;
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
		NotificacaoAmizade other = (NotificacaoAmizade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NotificacaoAmizade [id=" + id + ", usuario=" + usuario + ", seguirAmigo=" + seguirAmigo + ", instante="
				+ instante + ", dataResposta=" + dataResposta + ", respostaAmigo=" + respostaAmigo + "]";
	}

}
