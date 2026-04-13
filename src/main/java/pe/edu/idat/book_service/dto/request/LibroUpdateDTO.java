package pe.edu.idat.book_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import pe.edu.idat.book_service.constants.AppConstants;

public class LibroUpdateDTO {

	@NotBlank(message = "El título es obligatorio")
    @Size(min = AppConstants.MIN_TITULO, max = AppConstants.MAX_TITULO, message = AppConstants.MSG_TITULO)
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    @Size(min = AppConstants.MIN_AUTOR, max = AppConstants.MAX_AUTOR, message = AppConstants.MSG_AUTOR)
    @Pattern(regexp = AppConstants.REGEX_SOLO_LETRAS, message = AppConstants.MSG_AUTOR)
    private String autor;

    @NotBlank(message = "El género es obligatorio")
    @Size(min = AppConstants.MIN_GENERO, max = AppConstants.MAX_GENERO, message = AppConstants.MSG_GENERO)
    @Pattern(regexp = AppConstants.REGEX_SOLO_LETRAS, message = AppConstants.MSG_GENERO)
    private String genero;

    @NotBlank(message = "El ISBN es obligatorio")
    @Pattern(regexp = AppConstants.REGEX_ISBN, message = AppConstants.MSG_ISBN)
    private String isbn;
    
    public LibroUpdateDTO() {}

    public LibroUpdateDTO(String titulo, String autor, String genero, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.isbn = isbn;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	} 
}
