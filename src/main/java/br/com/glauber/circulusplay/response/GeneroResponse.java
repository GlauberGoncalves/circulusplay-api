package br.com.glauber.circulusplay.response;

import br.com.glauber.circulusplay.domain.Genero;

public class GeneroResponse {
	
	private Integer id;
	private String name;
	
	public GeneroResponse() {
		
	}
	
	public GeneroResponse(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Genero geraGenero() {
		return new Genero(this.id, this.name);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
