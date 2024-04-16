package it.prova.menupizzeria.exception;

public class PizzeriaExceptions extends Exception{
	
	
	
	public static void controlloIdDuranteInsert(Long id) {
		if (id != null) {
			System.out.println("ERRORE: ID non valido ");
		}
	}
	
	
	

}
