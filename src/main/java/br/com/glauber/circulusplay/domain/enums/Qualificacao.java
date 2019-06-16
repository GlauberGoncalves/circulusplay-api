package br.com.glauber.circulusplay.domain.enums;

public enum Qualificacao {
	LATA(1, "Lata"),
	BRONZE(2, "Bronze"),
	PRATA(3, "Prata"),
	OURO(4, "Ouro"),
	DIAMANTE(5, "Diamante");
	
	private int cod;
	private String descricao;
	
	private Qualificacao(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;		
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static Qualificacao toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (Qualificacao x : Qualificacao.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
