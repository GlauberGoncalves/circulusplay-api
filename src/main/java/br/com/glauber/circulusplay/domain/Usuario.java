package br.com.glauber.circulusplay.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobrenome;
	private String email;
	private Date nascimento;
	private String senha;	
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "FILMES_FAVORITOS",
			joinColumns = @JoinColumn(name = "filme_id"),
			inverseJoinColumns = @JoinColumn(name = "usuario_id")
		)
	private List<Filme> favoritos = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "FILMES_NAO_GOSTEI",
			joinColumns = @JoinColumn(name = "filme_id"),
			inverseJoinColumns = @JoinColumn(name = "usuario_id")
		)	
	private List<Filme> nãoGostei = new ArrayList<>();		
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "AMIGOS",
			joinColumns = @JoinColumn(name = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "amigo_id")
		)
	private List<Usuario> amigos = new ArrayList<>();
	
	public Usuario() {
	}

	public Usuario(Integer id, String nome, String sobrenome, String email, Date nascimento, String senha) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.nascimento = nascimento;
		this.senha = senha;
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email
				+ ", nascimento=" + nascimento + "]";
	}

	public List<Filme> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Filme> favoritos) {
		this.favoritos = favoritos;
	}

}
