package pe.edu.idat.book_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.idat.book_service.dto.response.EstadisticasDTO;
import pe.edu.idat.book_service.service.ILibroService;

@RestController
@RequestMapping("/api/admin/libros")
@PreAuthorize("hasRole('ADMIN')")
public class LibroAdminController {

    private final ILibroService libroService;

    public LibroAdminController(ILibroService libroService) {
        this.libroService = libroService;
    }

    private String getUsuarioActual() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Integer id) {
        libroService.eliminarLibro(id, getUsuarioActual());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/estadisticas")
    public ResponseEntity<EstadisticasDTO> obtenerEstadisticas() {
        return ResponseEntity.ok(libroService.obtenerEstadisticas());
    }
}