package pe.edu.idat.book_service.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LibroRequestDTO {

	@NotBlank(message = "El título es obligatorio")
    @Size(min = 1, max = 200, message = "El título debe tener entre 1 y 200 caracteres")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    @Size(min = 2, max = 150, message = "El autor debe tener entre 2 y 150 caracteres")
    private String autor;

    @NotBlank(message = "El género es obligatorio")
    @Size(max = 80, message = "El género no puede exceder 80 caracteres")
    private String genero;

    @NotBlank(message = "El ISBN es obligatorio")
    @Size(max = 20, message = "El ISBN no puede exceder 20 caracteres")
    private String isbn;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
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