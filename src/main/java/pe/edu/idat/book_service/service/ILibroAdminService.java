package pe.edu.idat.book_service.service;

import pe.edu.idat.book_service.dto.response.EstadisticasDTO;

public interface ILibroAdminService {
    void eliminarLibro(Integer id, String usuario);
    EstadisticasDTO obtenerEstadisticas();
}