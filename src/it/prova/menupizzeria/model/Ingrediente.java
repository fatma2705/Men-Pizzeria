package it.prova.menupizzeria.model;

public class Ingrediente {
	private String nome;
	private boolean disponibile;
	
	
	public Ingrediente() {
		
	}


	public Ingrediente(String nome, boolean disponibile) {
		
		this.nome = nome;
		this.disponibile = disponibile;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public boolean isDisponibile() {
		return disponibile;
	}


	public void setDisponibile(boolean disponibile) {
		this.disponibile = disponibile;
	}


	@Override
	public String toString() {
		return "Ingrediente [nome=" + nome + ", disponibile=" + disponibile + "]";
	}
	
	
	
	
	

}
