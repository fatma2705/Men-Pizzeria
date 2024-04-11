package it.prova.menupizzeria.service;

import java.util.List;

import it.prova.menupizzeria.dao.PizzaDAO;
import it.prova.menupizzeria.model.Pizza;

public interface PizzaService {
	
public List<Pizza> listAll() throws Exception;
	
	public Pizza listElemento(Long id) throws Exception;
	
	public void inserieciElemento(Pizza pizzaInstance);
	
	public void rimuovi(Pizza pizzaInstance);
	
	public void setPizzaDAO(PizzaDAO pizzaInstance);
	

}
