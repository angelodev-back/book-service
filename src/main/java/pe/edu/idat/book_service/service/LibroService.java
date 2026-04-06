package pe.edu.idat.book_service.service;

import pe.edu.idat.book_service.entity.Libro;
import pe.edu.idat.book_service.repository.LibroRepository;
import org.springframework.stereotype.Service;

import pe.edu.idat.book_service.exception.BadRequestException;
import pe.edu.idat.book_service.exception.ResourceNotFoundException;
import pe.edu.idat.book_service.exception.DuplicateResourceException;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // =========================
    // REGISTRAR LIBRO
    // =========================
    public Libro guardar(Libro libro) {

        // VALIDACIONES
        if (libro.getTitulo() == null || libro.getTitulo().isBlank()) {
            throw new BadRequestException("El titulo es obligatorio");
        }

        if (libro.getAutor().matches(".*\\d.*")) {
            throw new BadRequestException("El autor no debe contener números");
        }

        if (libro.getGenero().matches(".*\\d.*")) {
            throw new BadRequestException("El genero no debe contener números");
        }

        if (libro.getStock() < 0) {
            throw new BadRequestException("El stock no puede ser negativo");
        }

        // VALIDAR ISBN ÚNICO
        libroRepository.findByIsbn(libro.getIsbn())
                .ifPresent(l -> {
                    throw new DuplicateResourceException("El ISBN ya existe");
                });

        // ESTADO POR DEFECTO
        if (libro.getEstado() == null) {
            libro.setEstado("ACTIVO");
        }

        return libroRepository.save(libro);
    }

    // =========================
    // LISTAR TODOS
    // =========================
    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    public Libro buscarPorId(Integer id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Libro no encontrado"));
    }

    // =========================
    // BUSCAR POR GENERO
    // =========================
    public List<Libro> buscarPorGenero(String genero) {

        if (genero.matches(".*\\d.*")) {
            throw new RuntimeException("El género no debe contener números");
        }

        return libroRepository.findByGeneroIgnoreCase(genero);
    }

    // =========================
    // BUSCAR POR TITULO
    // =========================
    public List<Libro> buscarPorTitulo(String titulo) {
        return libroRepository.findByTituloContainingIgnoreCase(titulo);
    }

    // =========================
    // BUSCAR POR AUTOR
    // =========================
    public List<Libro> buscarPorAutor(String autor) {
        return libroRepository.findByAutorContainingIgnoreCase(autor);
    }

    // =========================
    // LIBROS DISPONIBLES
    // =========================
    public List<Libro> listarDisponibles() {
        return libroRepository.findByEstadoAndStockGreaterThan("ACTIVO", 0);
    }

    // =========================
    // ACTUALIZAR
    // =========================
    public Libro actualizar(Integer id, Libro libro) {

        Libro existente = buscarPorId(id);

        existente.setTitulo(libro.getTitulo());
        existente.setAutor(libro.getAutor());
        existente.setGenero(libro.getGenero());
        existente.setStock(libro.getStock());
        existente.setEstado(libro.getEstado());

        return libroRepository.save(existente);
    }
}