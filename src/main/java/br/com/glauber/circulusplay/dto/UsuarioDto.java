package br.com.glauber.circulusplay.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.glauber.circulusplay.domain.FilmeAssistido;
import br.com.glauber.circulusplay.domain.Usuario;

public class UsuarioDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String sobrenome;
	private String email;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date nascimento;
	private List<FilmeAssistidoDto> filmesAssistidos = new ArrayList<>();
	private List<UsuarioDto> amigos = new ArrayList<>();

	public UsuarioDto(Usuario usuario) {

		this.setId(usuario.getId());
		this.setNome(usuario.getNome());
		this.setEmail(usuario.getEmail());
		this.setSobrenome(usuario.getSobrenome());
		this.setNascimento(usuario.getNascimento());
		this.setFilmesAssistidos(usuario.getFilmesAssistidos().stream().map(FilmeAssistidoDto::new).collect(Collectors.toList()));
		this.setAmigos(usuario.getAmigos().stream().map(UsuarioDto::new).collect(Collectors.toList()));
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

	public List<FilmeAssistidoDto> getFilmesAssistidos() {
		return filmesAssistidos;
	}

	public void setFilmesAssistidos(List<FilmeAssistidoDto> filmesAssistidos) {
		this.filmesAssistidos = filmesAssistidos;
	}

	public List<UsuarioDto> getAmigos() {
		return amigos;
	}

	public void setAmigos(List<UsuarioDto> amigos) {
		this.amigos = amigos;
	}

}
