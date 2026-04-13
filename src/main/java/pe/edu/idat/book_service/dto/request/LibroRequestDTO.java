package pe.edu.idat.book_service.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import pe.edu.idat.book_service.constants.AppConstants;

public class LibroRequestDTO {

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

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = AppConstants.MSG_STOCK)
    private Integer stock;


    public LibroRequestDTO() {}

    public LibroRequestDTO(String titulo, String autor, String genero, String isbn, Integer stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.isbn = isbn;
        this.stock = stock;
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
}