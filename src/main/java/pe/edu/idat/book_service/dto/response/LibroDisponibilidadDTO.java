package pe.edu.idat.book_service.dto.response;

public class LibroDisponibilidadDTO {

	private Integer idLibro;
    private boolean disponible;
    private Integer stockActual;
    private boolean puedePrestar;

    public LibroDisponibilidadDTO() {}

    public LibroDisponibilidadDTO(Integer idLibro, boolean disponible, Integer stockActual, boolean puedePrestar) {
        this.idLibro = idLibro;
        this.disponible = disponible;
        this.stockActual = stockActual;
        this.puedePrestar = puedePrestar;
    }

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Integer getStockActual() {
		return stockActual;
	}

	public void setStockActual(Integer stockActual) {
		this.stockActual = stockActual;
	}

	public boolean isPuedePrestar() {
		return puedePrestar;
	}

	public void setPuedePrestar(boolean puedePrestar) {
		this.puedePrestar = puedePrestar;
	}
}
