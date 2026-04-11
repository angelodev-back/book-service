package pe.edu.idat.book_service.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.edu.idat.book_service.dto.response.LibroBasicoDTO;
import pe.edu.idat.book_service.dto.response.LibroDisponibilidadDTO;
import pe.edu.idat.book_service.entity.Libro;
import pe.edu.idat.book_service.exception.LibroNotFoundException;
import pe.edu.idat.book_service.exception.StockInsuficienteException;
import pe.edu.idat.book_service.mapper.LibroMapper;
import pe.edu.idat.book_service.repostory.LibroBaseRepository;
import pe.edu.idat.book_service.service.ILibroInternoService;

@Service
public class LibroInternoServiceImpl implements ILibroInternoService {

    private final LibroBaseRepository baseRepository;
    private final LibroMapper libroMapper;

    public LibroInternoServiceImpl(LibroBaseRepository baseRepository,
                                   LibroMapper libroMapper) {
        this.baseRepository = baseRepository;
        this.libroMapper = libroMapper;
    }

    @Override
    public LibroDisponibilidadDTO validarDisponibilidad(Integer id) {
        Libro libro = baseRepository.findById(id)
                .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado con ID: " + id));
        boolean disponible = "ACTIVO".equals(libro.getEstado()) && libro.getStock() > 0;
        return new LibroDisponibilidadDTO(id, disponible, libro.getStock(), disponible);
    }

    @Override
    @Transactional
    public void prestarLibro(Integer id) {
        Libro libro = baseRepository.findById(id)
                .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado con ID: " + id));
        if (!"ACTIVO".equals(libro.getEstado())) {
            throw new StockInsuficienteException("El libro no está activo");
        }
        if (libro.getStock() <= 0) {
            throw new StockInsuficienteException("No hay stock disponible");
        }
        libro.setStock(libro.getStock() - 1);
        libro.setLastModifiedDate(LocalDateTime.now());
        baseRepository.save(libro);
    }

    @Override
    @Transactional
    public void devolverLibro(Integer id) {
        Libro libro = baseRepository.findById(id)
                .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado con ID: " + id));
        libro.setStock(libro.getStock() + 1);
        libro.setLastModifiedDate(LocalDateTime.now());
        baseRepository.save(libro);
    }

    @Override
    public LibroBasicoDTO obtenerDatosBasicos(Integer id) {
        Libro libro = baseRepository.findById(id)
                .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado con ID: " + id));
        return libroMapper.toBasicoDTO(libro);
    }
}