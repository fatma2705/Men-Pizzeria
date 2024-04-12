package it.prova.menupizzeria.service;

import java.util.List;

import it.prova.menupizzeria.dao.IngredienteDAO;
import it.prova.menupizzeria.dao.PizzaDAO;
import it.prova.menupizzeria.model.Pizza;

public interface PizzaService {
	
public List<Pizza> listAll() throws Exception;
	
	public Pizza listElemento(Long id) throws Exception;
	
	
	public void inserieciElemento(Pizza pizzaInstance)throws Exception;
	
	public void rimuovi(Pizza pizzaInstance)throws Exception;
	
	public void aggiorna(Pizza pizzaInstance)throws Exception;
	
	public void setPizzaDAO(PizzaDAO pizzaInstance)throws Exception;
	
	public void setIngredienteDAO(IngredienteDAO ingredienteInstance)throws Exception;
	

}
