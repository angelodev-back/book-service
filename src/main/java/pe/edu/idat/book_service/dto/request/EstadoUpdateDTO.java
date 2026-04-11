package pe.edu.idat.book_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class EstadoUpdateDTO {

	@NotBlank(message = "El estado es obligatorio")
    @Pattern(regexp = "ACTIVO|INACTIVO", message = "Estado debe ser ACTIVO o INACTIVO")
    private String estado;

    public EstadoUpdateDTO() {}

    public EstadoUpdateDTO(String estado) {
        this.estado = estado;
    }

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
