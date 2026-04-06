package pe.edu.idat.book_service.repository;

import pe.edu.idat.book_service.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

    Optional<Libro> findByIsbn(String isbn);

    List<Libro> findByGeneroIgnoreCase(String genero);

    List<Libro> findByTituloContainingIgnoreCase(String titulo);

    List<Libro> findByAutorContainingIgnoreCase(String autor);

    List<Libro> findByEstadoAndStockGreaterThan(String estado, Integer stock);
}