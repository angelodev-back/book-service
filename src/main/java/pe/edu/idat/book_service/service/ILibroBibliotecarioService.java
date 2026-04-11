package pe.edu.idat.book_service.service;

import java.util.List;

import pe.edu.idat.book_service.dto.request.LibroRequestDTO;
import pe.edu.idat.book_service.dto.request.LibroUpdateDTO;
import pe.edu.idat.book_service.dto.response.LibroDetalleDTO;

public interface ILibroBibliotecarioService {
	List<LibroDetalleDTO> listarTodos();
    LibroDetalleDTO buscarPorIdDetalle(Integer id);
    LibroDetalleDTO registrarLibro(LibroRequestDTO dto, String usuario);
    LibroDetalleDTO actualizarLibro(Integer id, LibroUpdateDTO dto, String usuario);
    void ajustarStock(Integer id, Integer cantidad, String motivo, String usuario);
    void cambiarEstado(Integer id, String estado, String usuario);
}