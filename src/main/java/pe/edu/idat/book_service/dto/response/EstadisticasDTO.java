package pe.edu.idat.book_service.dto.response;

import java.util.Map;

public class EstadisticasDTO {

	private long totalLibrosActivos;
    private long totalLibrosInactivos;
    private Integer stockTotal;
    private Map<String, Long> librosPorGenero;

    public EstadisticasDTO() {}

    public EstadisticasDTO(long totalLibrosActivos, long totalLibrosInactivos, 
                           Integer stockTotal, Map<String, Long> librosPorGenero) {
        this.totalLibrosActivos = totalLibrosActivos;
        this.totalLibrosInactivos = totalLibrosInactivos;
        this.stockTotal = stockTotal;
        this.librosPorGenero = librosPorGenero;
    }
    
	public long getTotalLibrosActivos() {
		return totalLibrosActivos;
	}

	public void setTotalLibrosActivos(long totalLibrosActivos) {
		this.totalLibrosActivos = totalLibrosActivos;
	}

	public long getTotalLibrosInactivos() {
		return totalLibrosInactivos;
	}

	public void setTotalLibrosInactivos(long totalLibrosInactivos) {
		this.totalLibrosInactivos = totalLibrosInactivos;
	}

	public Integer getStockTotal() {
		return stockTotal;
	}

	public void setStockTotal(Integer stockTotal) {
		this.stockTotal = stockTotal;
	}

	public Map<String, Long> getLibrosPorGenero() {
		return librosPorGenero;
	}

	public void setLibrosPorGenero(Map<String, Long> librosPorGenero) {
		this.librosPorGenero = librosPorGenero;
	}
}
