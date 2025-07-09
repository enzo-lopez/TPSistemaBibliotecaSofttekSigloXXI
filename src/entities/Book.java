package entities;

import helpers.LibraryException;
// Javier Rameri // Forzar conflicto
public class Book {
	private String isbn;
	private String titulo;
	private String autor;
	private int anioPublicacion;
	private boolean disponibilidad;
	
	public Book(String isbn, String titulo, String autor, int anioPublicacion, boolean disponibilidad) throws LibraryException {
		setISBN(isbn);
		this.titulo = titulo;
		this.autor = autor;
		setAnioPublicacion(anioPublicacion);
		this.disponibilidad = disponibilidad;
	}

	public String getISBN() {
		return isbn;
	}

	public void setISBN(String iSBN) throws LibraryException {
		if (iSBN == null || iSBN.isEmpty()) {
			throw new LibraryException("ERROR: El ISBN no puede estar vacio.");
		}
		this.isbn = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) throws LibraryException {
		if(anioPublicacion < 0) {
			throw new LibraryException("ERROR: El año de publicación no puede ser negativo");
		}
		this.anioPublicacion = anioPublicacion;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	@Override
	public String toString() {
		return " " + isbn + ", " + titulo + " (" + getClass().getSimpleName() + ")";
	}
	
	
	
}
