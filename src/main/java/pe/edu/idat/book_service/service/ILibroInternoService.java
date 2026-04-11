package pe.edu.idat.book_service.service;

import pe.edu.idat.book_service.dto.response.LibroBasicoDTO;
import pe.edu.idat.book_service.dto.response.LibroDisponibilidadDTO;

public interface ILibroInternoService {
	LibroDisponibilidadDTO validarDisponibilidad(Integer id);
    void prestarLibro(Integer id);
    void devolverLibro(Integer id);
    LibroBasicoDTO obtenerDatosBasicos(Integer id);
}