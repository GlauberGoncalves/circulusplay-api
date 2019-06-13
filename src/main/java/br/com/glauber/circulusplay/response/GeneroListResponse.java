package br.com.glauber.circulusplay.response;

import java.util.List;
import java.util.stream.Collectors;

import br.com.glauber.circulusplay.domain.Genero;

public class GeneroListResponse {
	
	private List<GeneroResponse> genres;

	public GeneroListResponse() {
		
	}

	public List<GeneroResponse> getGenres() {
		return genres;
	}

	public void setGenres(List<GeneroResponse> genres) {
		this.genres = genres;
	}
	
	public List<Genero> getGeneros(){
		return this.genres.stream().map(obj -> new Genero(obj.getId(), obj.getName())).collect(Collectors.toList());
	}

}
