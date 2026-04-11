package pe.edu.idat.book_service.dto.response;

public class LibroResponseDTO {

	private Integer idLibro;
    private String titulo;
    private String autor;
    private String genero;
    private Integer stock;

    public LibroResponseDTO() {}

    public LibroResponseDTO(Integer idLibro, String titulo, String autor, String genero, Integer stock) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.stock = stock;
    }

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
}
