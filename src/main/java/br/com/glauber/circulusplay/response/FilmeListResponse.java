package br.com.glauber.circulusplay.response;

import java.util.List;

public class FilmeListResponse {

	private List<FilmeResponse> results;

	public FilmeListResponse() {

	}

	public List<FilmeResponse> getResults() {
		return results;
	}

	public void setResults(List<FilmeResponse> results) {
		this.results = results;
	}

}
