package pe.edu.idat.book_service.service;

import java.util.List;

import pe.edu.idat.book_service.dto.request.LibroRequestDTO;
import pe.edu.idat.book_service.dto.request.LibroUpdateDTO;
import pe.edu.idat.book_service.dto.response.EstadisticasDTO;
import pe.edu.idat.book_service.dto.response.LibroBasicoDTO;
import pe.edu.idat.book_service.dto.response.LibroDetalleDTO;
import pe.edu.idat.book_service.dto.response.LibroDisponibilidadDTO;
import pe.edu.idat.book_service.dto.response.LibroResponseDTO;

public interface ILibroService {
    // PÚBLICO
    List<LibroResponseDTO> listarLibrosDisponibles();
    LibroResponseDTO buscarPorId(Integer id);
    List<LibroResponseDTO> buscarPorTitulo(String titulo);
    List<LibroResponseDTO> buscarPorAutor(String autor);
    List<LibroResponseDTO> buscarPorGenero(String genero);

    // BIBLIOTECARIO
    List<LibroDetalleDTO> listarTodos();
    LibroDetalleDTO buscarPorIdDetalle(Integer id);
    LibroDetalleDTO registrarLibro(LibroRequestDTO dto, String usuario);
    LibroDetalleDTO actualizarLibro(Integer id, LibroUpdateDTO dto, String usuario);
    void ajustarStock(Integer id, Integer cantidad, String motivo, String usuario);
    void cambiarEstado(Integer id, String estado, String usuario);

    // ADMIN
    void eliminarLibro(Integer id, String usuario);
    EstadisticasDTO obtenerEstadisticas();

    // INTERNO
    LibroDisponibilidadDTO validarDisponibilidad(Integer id);
    void prestarLibro(Integer id);
    void devolverLibro(Integer id);
    LibroBasicoDTO obtenerDatosBasicos(Integer id);
}