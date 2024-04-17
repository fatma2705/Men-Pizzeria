package it.prova.menupizzeria.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import it.prova.menupizzeria.model.Ingrediente;
import it.prova.menupizzeria.model.Pizza;
import it.prova.menupizzeria.service.IngredienteService;
import it.prova.menupizzeria.service.MyServiceFactory;
import it.prova.menupizzeria.service.PizzaService;

public class TestInterfaceUtente {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("Benvenuto nella tua interfaccia utente. Scegli un'opzione:");
			System.out.println("1. Aggiungere una pizza");
			System.out.println("2. Leggere una pizza");
			System.out.println("3. Aggiornare una pizza");
			System.out.println("4. Eliminare una pizza");
			System.out.println("5. Aggiungere un' ingrediente");
			System.out.println("6. Leggere un' ingrediente");
			System.out.println("7. Aggiornare un' ingrediente");
			System.out.println("8. Eliminareun' ingrediente");
			System.out.println("9. Uscire");

			int choice = scanner.nextInt();
			scanner.nextLine();

			PizzaService pizzaServiceInstance = MyServiceFactory.getpizzaServiceInstance();
			IngredienteService ingredienteServiceInstance = MyServiceFactory.getIngredienteServiceInstance();

			switch (choice) {
			case 1:
				System.out.println("Ha scelto il primo comando per creare una pizza");
				System.out.println("Inserisci il prezzo della pizza da creare:");
				Float prezzo = null;
				try {
					prezzo = scanner.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("ERRORE : non è  stato inserito un float ");
					System.exit(0);
				}
				scanner.nextLine();

				System.out.println("Inserisci il nome della pizza da creare:");

				String nome = "";
				try {
					nome = scanner.nextLine();
				} catch (InputMismatchException e) {
					System.out.println("ERRORE : non è  stata inserita una stringa ");
					System.exit(0);

				}

				System.out.println("Inserisci true se la pizza è custom, false se non lo è:");
				boolean custom = false;
				try {
					custom = scanner.nextBoolean();
				} catch (InputMismatchException e) {
					System.out.println("ERRORE : non è  stato inserito un boolean ");
					System.exit(0);

				}
				scanner.nextLine();

				Pizza pizza = new Pizza(null, prezzo, nome, custom);
				TestMenuPizzeria.inserisciPizza(pizzaServiceInstance, pizza);

				break;
			case 2:
				System.out.println("Ha scelto il secondo comando per stampare una pizza");
				System.out.println("Inserisci L'id  della pizza da leggere:");
				Long id = null;
				try {
					id = scanner.nextLong();
				} catch (InputMismatchException e) {
					System.out.println("ERRORE : non è  stato inserito un long ");
					System.exit(0);
				}
				scanner.nextLine();
				TestMenuPizzeria.getPizza(pizzaServiceInstance, id);

			case 3:
				System.out.println("Ha scelto il terzo comando per aggiornare una pizza");
				System.out.println("Inserisci L'id  della pizza da aggiornare:");
				Long idP = null;
				try {
					idP = scanner.nextLong();
				} catch (InputMismatchException e) {
					System.out.println("ERRORE : non è  stato inserito un long ");
					System.exit(0);
				}
				scanner.nextLine();
				System.out.println("Inserisci il nuovo prezzo della pizza da aggiornare:");
				Float prezzoP = null;
				try {
					prezzoP = scanner.nextFloat();
				} catch (InputMismatchException e) {
					System.out.println("ERRORE : non è  stato inserito un float ");
					System.exit(0);
				}
				scanner.nextLine();
				System.out.println("Inserisci il nuovo nome della pizza da aggiornare:");
				String nomeP = "";
				try {
					nomeP = scanner.nextLine();
				} catch (InputMismatchException e) {
					System.out.println("ERRORE : non è  stata inserita una stringa ");
					System.exit(0);
				}
				System.out.println("Inserisci true se la pizza è custom, false se non lo è:");
				boolean customP = false;
				try {
					customP = scanner.nextBoolean();
				} catch (InputMismatchException e) {
					System.out.println("ERRORE : non è  stato inserito un boolean ");
					System.exit(0);
				}
				scanner.nextLine();
				Pizza pizzaP = new Pizza(idP, prezzoP, nomeP, customP);
				TestMenuPizzeria.aggiornaPizza(pizzaServiceInstance, pizzaP);

				break;
			case 4:
				System.out.println("Ha scelto il quarto comando per eliminare una pizza");
				System.out.println("Inserisci L'id  della pizza da eliminare:");
				Long idp = null;
				try {
					idp = scanner.nextLong();
				} catch (InputMismatchException e) {
					System.out.println("ERRORE : non è  stato inserito un Long ");
					System.exit(0);
				}
				scanner.nextLine();
				Pizza pizzap = new Pizza(idp);
				TestMenuPizzeria.rimuoviPizza(pizzaServiceInstance, pizzap);

				break;
			case 5:
				System.out.println("Ha scelto il quinto comando per aggiungere un' ingrediente");

				System.out.println("Inserisci il nome dell' ingrediente da aggiungere:");
				String nomeIngrediente = scanner.nextLine();

				System.out.println("Inserisci true se l' ingrediente è disponibile, false se non lo è:");
				boolean disponibile = scanner.nextBoolean();
				scanner.nextLine();

				Ingrediente ingrediente = new Ingrediente(null, nomeIngrediente, disponibile);
				TestMenuPizzeria.inserisciIngrediente(ingredienteServiceInstance, ingrediente);

				break;
			case 6:
				System.out.println("Ha scelto il sesto comando per stampare un' ingrediente");
				System.out.println("Inserisci L'id  dell' ingrediente da leggere:");
				Long idIngrediente = scanner.nextLong();
				scanner.nextLine();
				TestMenuPizzeria.getIngrediente(ingredienteServiceInstance, idIngrediente);
				;

			case 7:
				System.out.println("Ha scelto il settimo comando per aggiornare un ' ingrediente");
				System.out.println("Inserisci L'id  dell ' ingrediente da aggiornare:");
				Long idI = scanner.nextLong();
				scanner.nextLine();

				System.out.println("Inserisci il nome dell' ingrediente da aggiornare:");
				String nomeI = scanner.nextLine();

				System.out.println("Inserisci true se l' ingrediente è disponibile, false se non lo è:");
				boolean disponibileI = scanner.nextBoolean();
				scanner.nextLine();

				Ingrediente ingredienteInsert = new Ingrediente(idI, nomeI, disponibileI);
				TestMenuPizzeria.aggiornaIngrediente(ingredienteServiceInstance, ingredienteInsert);

				break;
			case 8:
				System.out.println("Ha scelto l' ottavo comando per eliminare un ' ingrediente");
				System.out.println("Inserisci L'id  dell' ingrediente da eliminare:");
				Long idIn = scanner.nextLong();
				scanner.nextLine();
				Ingrediente ingredienteE = new Ingrediente(idIn);
				TestMenuPizzeria.rimuoviIngrediente(ingredienteServiceInstance, ingredienteE);

				break;
			case 9:
				exit = true;
				break;
			default:
				System.out.println("Opzione non valida. Riprova.");
			}
		}

		System.out.println("Grazie per aver usato l'interfaccia utente. Arrivederci!");
		scanner.close();
	}

}
