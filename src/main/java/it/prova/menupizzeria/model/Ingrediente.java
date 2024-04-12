package it.prova.menupizzeria.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "ingrediente")

public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "disponibile")
	private boolean disponibile;
	
	@ManyToMany(mappedBy = "ingredienti")
    private Set<Pizza> pizze = new HashSet<>();
	
	
	
	public Ingrediente() {
		
	}
	
	
	public Ingrediente(Long id) {
		this.id = id;
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