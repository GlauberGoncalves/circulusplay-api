package br.com.glauber.circulusplay.response;

import java.util.Date;
import java.util.List;

import br.com.glauber.circulusplay.domain.Filme;

public class FilmeResponse {

	private Integer id;
	private boolean adult;
	private String backdrop_path;
	private Integer budget;
	private Date release_date;
	private String title;
	private Double vote_average;
	private String poster_path;
	private String overview;
	private List<GeneroResponse> genres;

	public FilmeResponse() {

	}

	public FilmeResponse(boolean adult, String backdrop_path, Integer budget, Date release_date, String title,
			Double vote_average, String overview) {
		this.adult = adult;
		this.backdrop_path = backdrop_path;
		this.budget = budget;
		this.release_date = release_date;
		this.title = title;
		this.vote_average = vote_average;
		this.overview = overview;
	}

	public Filme geraFilme() {
		Filme filme = new Filme();
		filme.setId(this.id);
		filme.setAdulto(this.adult);
		filme.setImagemFundo(this.backdrop_path);
		filme.setImagemPoster(this.poster_path);
		filme.setTitulo(this.title);
		filme.setDataLancamento(this.release_date);
		filme.setSinopse(this.overview);

		return filme;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public String getBackdrop_path() {
		return backdrop_path;
	}

	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getVote_average() {
		return vote_average;
	}

	public void setVote_average(Double vote_average) {
		this.vote_average = vote_average;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public List<GeneroResponse> getGenres() {
		return genres;
	}

	public void setGenres(List<GeneroResponse> genres) {
		this.genres = genres;
	}

}
