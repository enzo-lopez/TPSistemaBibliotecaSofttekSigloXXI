package services;

import java.util.List;

import entities.Book;

public interface IBookFilter {
	// Comentario por Agustín Aguirre
	public List<Book> autorFilter(List<Book> books, String autor);
	public List<Book> anioFilter(List<Book> books, int year);
	public List<Book> disponibilidadFilter(List<Book> books);
	
}
