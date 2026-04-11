package pe.edu.idat.book_service.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.idat.book_service.entity.Libro;

@Repository
public interface LibroAdminRepository extends JpaRepository<Libro, Integer> {
    
    @Query("SELECT l.genero, COUNT(l) FROM Libro l GROUP BY l.genero")
    List<Object[]> countLibrosByGenero();
    
    @Query("SELECT COUNT(l) FROM Libro l WHERE l.estado = 'ACTIVO'")
    long countLibrosActivos();
    
    @Query("SELECT COUNT(l) FROM Libro l WHERE l.estado = 'INACTIVO'")
    long countLibrosInactivos();
    
    @Query("SELECT SUM(l.stock) FROM Libro l WHERE l.estado = 'ACTIVO'")
    Integer sumStockTotal();
}