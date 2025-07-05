package services.implementations;

import entities.Book;
import helpers.LibraryException;
import services.IBookRepository;

public class LoanManager {
	
	private final IBookRepository repository;

    public LoanManager(IBookRepository repository) {
        this.repository = repository;
    }

    public void prestarLibro(String isbn) throws LibraryException {
        Book book = repository.buscarLibro(isbn);
        if (!book.isDisponibilidad()) {
        	throw new LibraryException("El libro ya esta prestado.");
        }
        book.setDisponibilidad(false);
    }

    public void devolverLibro(String isbn) throws LibraryException {
        Book book = repository.buscarLibro(isbn);
        if (book.isDisponibilidad()) {
        	throw new LibraryException("El libro ya fue devuelto.");
        }
        book.setDisponibilidad(true);
    }
}
