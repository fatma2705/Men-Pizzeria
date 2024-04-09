package it.prova.menupizzeria.model;

public class Ingrediente {
	private Long id;
	private String nome;
	private boolean disponibile;
	
	
	public Ingrediente() {
		
	}


	public Ingrediente(Long id,String nome, boolean disponibile) {
		
		this.nome = nome;
		this.disponibile = disponibile;
		this.id = id;
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
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Ingrediente [id=" + id + ", nome=" + nome + ", disponibile=" + disponibile + "]";
	}



	
	
	

}