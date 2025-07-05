package services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import entities.Book;
import services.IBookFilter;

public class BookFilter implements IBookFilter{

	@Override
	public List<Book> autorFilter(List<Book> books, String autor) {
		return books.stream()
                .filter(b -> b.getAutor().equalsIgnoreCase(autor))
                .collect(Collectors.toList());
	}

	@Override
	public List<Book> anioFilter(List<Book> books, int year) {
		return books.stream()
                .filter(b -> b.getAnioPublicacion() == year)
                .collect(Collectors.toList());
	}

	@Override
	public List<Book> disponibilidadFilter(List<Book> books) {
		return books.stream()
                .filter(Book::isDisponibilidad)
                .collect(Collectors.toList());
	}

	
}
