package it.prova.menupizzeria.service;

import java.util.List;

import it.prova.menupizzeria.dao.IngredienteDAO;
import it.prova.menupizzeria.model.Ingrediente;

public interface IngredienteService {
	
	public List<Ingrediente> listAll() throws Exception;
	
	public Ingrediente listElemento(Long id) throws Exception;
	
	public void inserieciElemento(Ingrediente ingredienteInstance);
	
	public void rimuovi(Ingrediente ingredienteInstance);
	
	public void setIngredienteDAO(IngredienteDAO ingredienteInstance);
	

}
