package it.prova.menupizzeria.service;

import java.util.List;

import it.prova.menupizzeria.dao.IngredienteDAO;
import it.prova.menupizzeria.dao.PizzaDAO;
import it.prova.menupizzeria.model.Ingrediente;

public interface IngredienteService {
	
	public List<Ingrediente> listAll() throws Exception;
	
	public Ingrediente listElemento(Long id) throws Exception;
	
	public void inserisciElemento(Ingrediente ingredienteInstance)throws Exception;
	
	public void rimuovi(Ingrediente ingredienteInstance)throws Exception;
	
	public void aggiorna(Ingrediente ingredienteInstance)throws Exception;
	
	public void setIngredienteDAO(IngredienteDAO ingredienteInstance)throws Exception;
	
	

}
