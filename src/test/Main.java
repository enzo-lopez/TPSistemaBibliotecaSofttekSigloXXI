package test;

import entities.Book;
import helpers.LibraryException;
import services.IBookRepository;
import services.implementations.ArrayListBookRepository;
import services.implementations.LoanManager;

public class Main {

	
	public static void main(String[] args) {
	
	try {
		IBookRepository repo = new ArrayListBookRepository();
		
		repo.agregarLibro(new Book("1234A", "CleanCode", "Juan", 2020, true));
		//repo.agregarLibro(new Book("", "CleanCode", "Juan", 2020, true)); // Lanza excepcion
	    repo.agregarLibro(new Book("5678B", "POO Avanzado", "Walter", 2021, true));
	    //repo.agregarLibro(new Book("5678B", "POO Avanzado", "Walter", 2021, true)); // Lanza excepcion
	    
	    LoanManager loanManager = new LoanManager(repo);
	
	    loanManager.prestarLibro("1234A");
	    //loanManager.prestarLibro("1234A"); // Lanza excepcion
		loanManager.devolverLibro("1234A");
		//loanManager.devolverLibro("1234A"); // Lanza excepcion
		
        // Mostramos todos los libros
        System.out.println("Todos los libros:\n");
        for (Book b : repo.traerLibros()) {
            System.out.println(b);
        }
    
	} catch (LibraryException e) {
		e.printStackTrace();
	}

	
	
	
	
	
	
	
	
	
	
	}
}