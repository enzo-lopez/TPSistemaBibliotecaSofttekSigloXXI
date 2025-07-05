package services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entities.Book;
import helpers.LibraryException;
import services.IBookRepository;

public class ArrayListBookRepository implements IBookRepository {
	private List<Book> books = new ArrayList<>();
	
	@Override
	public void agregarLibro(Book book) throws LibraryException {
		for(Book b : books) {
			if(b.getISBN().equals(book.getISBN())) {
				throw new LibraryException("El ISBN se encuentra duplicado.");
			}
		}
		books.add(book);
	}

	@Override
	public void eliminarLibro(String isbn) throws LibraryException {
		Book bookToRemove = null;
		
		for (Book b : books) {
			if(b.getISBN().equals(isbn)) {
				bookToRemove = b;
				break;
			}
		}
		
		if (bookToRemove == null) {
			throw new LibraryException("Libro no encontrado");
		}
		books.remove(bookToRemove);
	}

	@Override
	public Book buscarLibro(String isbn) throws LibraryException {
		if(isbn.isEmpty() || isbn == null) {
			throw new LibraryException("El campo para buscar libro se encuentra vacio");
		}
		Book book = null;
		for (Book b : books) {
			if (b.getISBN().equals(isbn)) {
				book = b;
				break;
			}
		}
		return book;
	}

	@Override
	public List<Book> traerLibros() {
		return books;
	}
	
}
