package it.prova.menupizzeria.dao;

import it.prova.menupizzeria.model.Ingrediente;

public interface IngredienteDAO extends IBaseDAO<Ingrediente> {
	
	public Ingrediente getByNome(String nome) throws Exception;

}
