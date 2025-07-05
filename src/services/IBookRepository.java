package services;

import java.util.List;

import entities.Book;
import helpers.LibraryException;

public interface IBookRepository {
    void agregarLibro(Book book) throws LibraryException;
    void eliminarLibro(String isbn) throws LibraryException;
    Book buscarLibro(String isbn) throws LibraryException;
    List<Book> traerLibros();
}
