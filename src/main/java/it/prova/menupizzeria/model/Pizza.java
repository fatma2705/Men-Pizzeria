package it.prova.menupizzeria.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza")

public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "prezzo")
	private float prezzo;
	@Column(name = "nome")
	private String nome;
	@Column(name = "custom")
	private boolean custom;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "pizza_ingrediente", joinColumns = @JoinColumn(name = "id_pizza", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_ingrediente", referencedColumnName = "id"))
	private Set<Ingrediente> ingredienti = new HashSet<>();

	public Pizza() {

	}

	public Pizza(Long id, float prezzo, String nome, boolean custom) {
		this.id = id;

		this.prezzo = prezzo;
		this.nome = nome;
		this.custom = custom;
	}

	public Pizza(Long id) {
		this.id = id;
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
		return "Pizza [id=" + id + ", prezzo=" + prezzo + ", nome=" + nome + ", custom=" + custom + "]"
				+ "Ingredienti : " + ingredienti.toString();
	}

}