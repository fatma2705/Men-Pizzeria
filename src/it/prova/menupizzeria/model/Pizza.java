package it.prova.menupizzeria.model;

import java.util.List;

public class Pizza {
	private List<Ingrediente> ingredienti;
	private float prezzo;
	private String  nome;
	private boolean custom;
	
	
	public Pizza() {
		
	
	}


	public Pizza(List<Ingrediente> ingredienti, float prezzo, String nome, boolean custom) {
		this.ingredienti = ingredienti;
		this.prezzo = prezzo;
		this.nome = nome;
		this.custom = custom;
	}


	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}


	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}


	public float getPrezzo() {
		return prezzo;
	}


	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public boolean isCustom() {
		return custom;
	}


	public void setCustom(boolean custom) {
		this.custom = custom;
	}


	@Override
	public String toString() {
		return "Pizza [ingredienti=" + ingredienti + ", prezzo=" + prezzo + ", nome=" + nome + ", custom=" + custom
				+ "]";
	}
	
	
	
	
	
	

}
