package pe.edu.idat.book_service.dto.request;

import jakarta.validation.constraints.NotNull;

public class StockUpdateDTO {

	@NotNull(message = "La cantidad es obligatoria")
    private Integer cantidad;
    private String motivo;

    public StockUpdateDTO() {}

    public StockUpdateDTO(Integer cantidad, String motivo) {
        this.cantidad = cantidad;
        this.motivo = motivo;
    }

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
