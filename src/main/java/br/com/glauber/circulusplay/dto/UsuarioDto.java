package br.com.glauber.circulusplay.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.glauber.circulusplay.domain.Filme;
import br.com.glauber.circulusplay.domain.Usuario;

public class UsuarioDto {

	private Integer id;
	private String nome;
	private String sobrenome;
	private String email;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date nascimento;
	private List<FilmeDto> favoritos = new ArrayList<>();
	private List<Filme> nãoGostei = new ArrayList<>();
	private List<Usuario> amigos = new ArrayList<>();	
	
	public UsuarioDto(Usuario usuario){
		
		this.setId(usuario.getId());
		this.setNome(usuario.getNome());
		this.setEmail(usuario.getEmail());
		this.setSobrenome(usuario.getSobrenome());
		this.setFavoritos(usuario.getFavoritos().stream().map(FilmeDto::new).collect(Collectors.toList()));
		
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

	public List<FilmeDto> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<FilmeDto> favoritos) {
		this.favoritos = favoritos;
	}

	public List<Filme> getNãoGostei() {
		return nãoGostei;
	}

	public void setNãoGostei(List<Filme> nãoGostei) {
		this.nãoGostei = nãoGostei;
	}

	public List<Usuario> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<Usuario> amigos) {
		this.amigos = amigos;
	}


}
