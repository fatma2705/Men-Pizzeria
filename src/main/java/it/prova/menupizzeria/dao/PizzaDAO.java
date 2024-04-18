package it.prova.menupizzeria.dao;

import it.prova.menupizzeria.model.Ingrediente;
import it.prova.menupizzeria.model.Pizza;

public interface PizzaDAO extends IBaseDAO<Pizza> {

	public void insertIngrediente(Pizza pizza, Ingrediente ingrediente) throws Exception;

	public void deletPizzaIngredienteAssociazione(Pizza pizza) throws Exception;

}
