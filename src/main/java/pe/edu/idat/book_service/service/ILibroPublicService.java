package pe.edu.idat.book_service.service;

import java.util.List;

import pe.edu.idat.book_service.dto.response.LibroResponseDTO;

public interface ILibroPublicService {
	List<LibroResponseDTO> listarLibrosDisponibles();
    LibroResponseDTO buscarPorId(Integer id);
    List<LibroResponseDTO> buscarPorTitulo(String titulo);
    List<LibroResponseDTO> buscarPorAutor(String autor);
    List<LibroResponseDTO> buscarPorGenero(String genero);
}