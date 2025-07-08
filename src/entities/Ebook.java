package entities;
// Enzo Lopez
import helpers.LibraryException;

public class Ebook extends Book{

	private String formato;
	
	public Ebook(String isbn, String titulo, String autor, int anioPublicacion, boolean disponibilidad,  String formato)
			throws LibraryException {
		super(isbn, titulo, autor, anioPublicacion, disponibilidad);
		
		this.formato = formato;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

}
