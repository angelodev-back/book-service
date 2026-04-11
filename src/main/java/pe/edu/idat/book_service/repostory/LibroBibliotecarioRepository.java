package pe.edu.idat.book_service.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.idat.book_service.entity.Libro;

@Repository
public interface LibroBibliotecarioRepository extends JpaRepository<Libro, Integer> {
    
    @Query("SELECT l FROM Libro l ORDER BY l.estado, l.titulo")
    List<Libro> findAllLibros();
}