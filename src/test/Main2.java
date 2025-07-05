package test;
import java.util.List;

import entities.Book;
import entities.Ebook;
import helpers.LibraryException;
import services.IBookRepository;
import services.implementations.ArrayBookRepository;
import services.implementations.ArrayListBookRepository;
import services.implementations.BookFilter;
import services.implementations.LoanManager;
import services.IBookFilter;

public class Main2 {

	public static void main(String[] args) {

	try {
        // El codigo depende de la interfaz, y no de una implementacion concreta
       // IBookRepository repo = new ArrayListBookRepository();
        IBookRepository repo = new ArrayBookRepository(2);
        
        // Agregamos un Book y un EBook (ambos tratados como Book)
        Book libro1 = new Book("111", "Java Basico", "Juan", 2020, true);
        Book libro2 = new Ebook("222", "POO Avanzado", "Ana", 2021, true, "PDF");

        repo.agregarLibro(libro1);
        repo.agregarLibro(libro2);

        // Mostramos todos los libros
        System.out.println("Todos los libros:\n");
        for (Book b : repo.traerLibros()) {
            System.out.println(b);
        }
        
        System.out.println("\n---------------------------");

        // Prestamo y devolución usando LoanManager
        LoanManager loanManager = new LoanManager(repo);
        loanManager.prestarLibro("111");
        loanManager.devolverLibro("111");
        loanManager.prestarLibro("222");
        loanManager.devolverLibro("222");

        // Uso de filtros personalizados
        IBookFilter filter = new BookFilter();
        
        List<Book> librosDeJuan = filter.autorFilter(repo.traerLibros(), "Juan");
        List<Book> libros2021 = filter.anioFilter(repo.traerLibros(), 2021);
        List<Book> disponibles = filter.disponibilidadFilter(repo.traerLibros());

        System.out.println("\nLibros de Juan:");
        for (Book b : librosDeJuan) {
            System.out.println(b);
        }

        System.out.println("\nLibros publicados en 2021:");
        for (Book b : libros2021) {
            System.out.println(b);
        }

        System.out.println("\nLibros disponibles:");
        for (Book b : disponibles) {
            System.out.println(b);
        }

    } catch (LibraryException e) {
        System.out.println("Error: " + e.getMessage());
    }

	}

}
