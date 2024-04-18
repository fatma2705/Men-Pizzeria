package it.prova.menupizzeria.dao;

import java.util.Set;

import it.prova.menupizzeria.model.Ingrediente;

public interface IngredienteDAO extends IBaseDAO<Ingrediente> {
	
	public Ingrediente getByNome(String nome) throws Exception;
	
	public void deleteIngredienti(Set<Ingrediente> ingredienti) throws Exception;

}
