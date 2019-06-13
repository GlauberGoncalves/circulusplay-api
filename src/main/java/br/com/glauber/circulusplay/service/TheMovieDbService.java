package br.com.glauber.circulusplay.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.glauber.circulusplay.domain.Filme;
import br.com.glauber.circulusplay.response.FilmeResponse;
import br.com.glauber.circulusplay.response.GeneroListResponse;
import br.com.glauber.circulusplay.service.exceptions.ObjectNotFoundException;

@Service
public class TheMovieDbService {
	
	public String url = "https://api.themoviedb.org/3";
	public String linguagem = "pt-Br";	
	private String key =  System.getenv("TheMovieDbKey");		
	private RestTemplate restTemplate = new RestTemplate();
		
	
	public FilmeResponse findFilmeById(Integer id){
		
		String url = String.format("%s/movie/%s?api_key=%s&sort_by=release_date.desc&language=pt-BR", this.url, id, this.key);
		FilmeResponse filme;
		try {
		
			filme = restTemplate.getForObject(url, FilmeResponse.class);
		
		} catch(Exception e) {
		
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo: " + Filme.class.getName());
		}
		
		return filme;
		
	  }
	
	
	public GeneroListResponse findAllGeneros(){
		
		String url = String.format("%s/genre/movie/list?api_key=%s&sort_by=release_date.desc&language=pt-BR", this.url, this.key);
		GeneroListResponse generos;
		
		try {
			System.out.println(url);
			System.out.println(this.key);
			generos = restTemplate.getForObject(url, GeneroListResponse.class);
		} catch(Exception e) {
			
			throw new ObjectNotFoundException("Genero não encontrado");
		}
		
		return generos;
	}

}
