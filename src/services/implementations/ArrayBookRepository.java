package services.implementations;

import java.util.ArrayList;
import java.util.List;

import entities.Book;
import helpers.LibraryException;
import services.IBookRepository;

public class ArrayBookRepository implements IBookRepository{

	private Book[] books;
	private int count = 0;
	
	public ArrayBookRepository(int size) {
		books = new Book[size];
	}
	
	@Override
	public void agregarLibro(Book book) throws LibraryException {
		if (count >= books.length) throw new LibraryException("Espacio lleno.");
		
        for (int i = 0; i < count; i++)
            if (books[i].getISBN().equals(book.getISBN())) {
                throw new LibraryException("El ISBN se encuentra duplicado.");
            }
        
        books[count++] = book;
	}

	@Override
	public void eliminarLibro(String isbn) throws LibraryException {
        int idx = -1;
        for (int i = 0; i < count; i++) {
            if (books[i].getISBN().equals(isbn)) { 
            	idx = i;
            	break; 
            }
        }
        
        if (idx == -1) {
        	throw new LibraryException("Libro no encontrado.");
        }
        
        for (int i = idx; i < count - 1; i++) {
            books[i] = books[i + 1];
        }
        
        books[--count] = null;
    }
		

	@Override
	public Book buscarLibro(String isbn) throws LibraryException {
		for (int i = 0; i < count; i++) {
            if (books[i].getISBN().equals(isbn)) {
            	return books[i];
            }
		}
		
        throw new LibraryException("Libro no encontrado.");
	}

	@Override
	public List<Book> traerLibros() {
		List<Book> list = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			list.add(books[i]);
		}
		return list;
	}

}
