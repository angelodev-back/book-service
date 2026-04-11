package pe.edu.idat.book_service.controller;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pe.edu.idat.book_service.dto.request.EstadoUpdateDTO;
import pe.edu.idat.book_service.dto.request.LibroRequestDTO;
import pe.edu.idat.book_service.dto.request.LibroUpdateDTO;
import pe.edu.idat.book_service.dto.request.StockUpdateDTO;
import pe.edu.idat.book_service.dto.response.LibroDetalleDTO;
import pe.edu.idat.book_service.service.ILibroService;

@RestController
@RequestMapping("/api/bibliotecario/libros")
@PreAuthorize("hasAnyRole('ADMIN', 'BIBLIOTECARIO')")
public class LibroBibliotecarioController {

    private final ILibroService libroService;

    public LibroBibliotecarioController(ILibroService libroService) {
        this.libroService = libroService;
    }

    private String getUsuarioActual() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @GetMapping
    public ResponseEntity<List<LibroDetalleDTO>> listarTodos() {
        return ResponseEntity.ok(libroService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDetalleDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(libroService.buscarPorIdDetalle(id));
    }

    @PostMapping
    public ResponseEntity<LibroDetalleDTO> registrarLibro(@Valid @RequestBody LibroRequestDTO request) {
        LibroDetalleDTO response = libroService.registrarLibro(request, getUsuarioActual());
        return ResponseEntity.status(HttpStatus.SC_CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDetalleDTO> actualizarLibro(
            @PathVariable Integer id,
            @Valid @RequestBody LibroUpdateDTO request) {
        LibroDetalleDTO response = libroService.actualizarLibro(id, request, getUsuarioActual());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<Void> ajustarStock(
            @PathVariable Integer id,
            @Valid @RequestBody StockUpdateDTO request) {
        libroService.ajustarStock(id, request.getCantidad(), request.getMotivo(), getUsuarioActual());
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Void> cambiarEstado(
            @PathVariable Integer id,
            @Valid @RequestBody EstadoUpdateDTO request) {
        libroService.cambiarEstado(id, request.getEstado(), getUsuarioActual());
        return ResponseEntity.noContent().build();
    }
}