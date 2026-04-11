package pe.edu.idat.book_service.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.edu.idat.book_service.dto.response.EstadisticasDTO;
import pe.edu.idat.book_service.entity.Libro;
import pe.edu.idat.book_service.exception.LibroNotFoundException;
import pe.edu.idat.book_service.repostory.LibroAdminRepository;
import pe.edu.idat.book_service.repostory.LibroBaseRepository;
import pe.edu.idat.book_service.service.ILibroAdminService;

@Service
public class LibroAdminServiceImpl implements ILibroAdminService {

    private final LibroBaseRepository baseRepository;
    private final LibroAdminRepository adminRepository;

    public LibroAdminServiceImpl(LibroBaseRepository baseRepository,
                                 LibroAdminRepository adminRepository) {
        this.baseRepository = baseRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    @Transactional
    public void eliminarLibro(Integer id, String usuario) {
        Libro libro = baseRepository.findById(id)
                .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado con ID: " + id));
        libro.setEstado("INACTIVO");
        libro.setModifiedBy(usuario);
        libro.setLastModifiedDate(LocalDateTime.now());
        baseRepository.save(libro);
    }

    @Override
    public EstadisticasDTO obtenerEstadisticas() {
        long activos = adminRepository.countLibrosActivos();
        long inactivos = adminRepository.countLibrosInactivos();
        Integer stockTotal = adminRepository.sumStockTotal();
        List<Object[]> conteoGeneros = adminRepository.countLibrosByGenero();
        Map<String, Long> librosPorGenero = new HashMap<>();
        for (Object[] row : conteoGeneros) {
            librosPorGenero.put((String) row[0], (Long) row[1]);
        }
        return new EstadisticasDTO(activos, inactivos, stockTotal, librosPorGenero);
    }
}