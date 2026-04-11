package pe.edu.idat.book_service.dto.response;

public class LibroBasicoDTO {

	private Integer idLibro;
    private String titulo;
    private String autor;
    private Integer stock;
    private String estado;

    public LibroBasicoDTO() {}

    public LibroBasicoDTO(Integer idLibro, String titulo, String autor, Integer stock, String estado) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.stock = stock;
        this.estado = estado;
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
