package pe.edu.idat.book_service.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.idat.book_service.entity.Libro;

@Repository
public interface LibroPublicRepository extends JpaRepository<Libro, Integer> {
    
    @Query("SELECT l FROM Libro l WHERE l.estado = 'ACTIVO' AND l.stock > 0 ORDER BY l.titulo")
    List<Libro> findAllActivosConStock();
    
    @Query("SELECT l FROM Libro l WHERE l.estado = 'ACTIVO' AND LOWER(l.titulo) LIKE LOWER(CONCAT('%', :titulo, '%'))")
    List<Libro> buscarPorTitulo(@Param("titulo") String titulo);
    
    @Query("SELECT l FROM Libro l WHERE l.estado = 'ACTIVO' AND LOWER(l.autor) LIKE LOWER(CONCAT('%', :autor, '%')) ORDER BY l.titulo")
    List<Libro> buscarPorAutor(@Param("autor") String autor);
    
    @Query("SELECT l FROM Libro l WHERE l.estado = 'ACTIVO' AND LOWER(l.genero) LIKE LOWER(CONCAT('%', :genero, '%')) ORDER BY l.titulo")
    List<Libro> buscarPorGenero(@Param("genero") String genero);
}