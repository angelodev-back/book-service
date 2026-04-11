package pe.edu.idat.book_service.repostory;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.idat.book_service.entity.Libro;

@Repository
public interface LibroBaseRepository extends JpaRepository<Libro, Integer> {
    
    Optional<Libro> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
    
    @Query("SELECT COUNT(l) > 0 FROM Libro l WHERE l.isbn = :isbn AND l.idLibro != :id")
    boolean existsByIsbnAndIdNot(@Param("isbn") String isbn, @Param("id") Integer id);
}