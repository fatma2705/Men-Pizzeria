package it.prova.menupizzeria.model;

import java.util.List;

public class Pizza {
	private Long id;
	private List<Ingrediente> ingredienti;
	private float prezzo;
	private String  nome;
	private boolean custom;
	
	
	public Pizza() {
		
	
	}


	public Pizza(Long id,List<Ingrediente> ingredienti, float prezzo, String nome, boolean custom) {
		this.id = id;
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
	
	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Pizza [id=" + id + ", ingredienti=" + ingredienti + ", prezzo=" + prezzo + ", nome=" + nome
				+ ", custom=" + custom + "]";
	}


	
	
	

}