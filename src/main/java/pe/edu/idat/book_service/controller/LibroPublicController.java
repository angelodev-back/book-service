package pe.edu.idat.book_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.idat.book_service.dto.response.LibroResponseDTO;
import pe.edu.idat.book_service.service.ILibroPublicService;

@RestController
@RequestMapping("/api/libros")
public class LibroPublicController {

    private final ILibroPublicService libroPublicService;

    public LibroPublicController(ILibroPublicService libroPublicService) {
        this.libroPublicService = libroPublicService;
    }

    @GetMapping
    public ResponseEntity<List<LibroResponseDTO>> listarDisponibles() {
        return ResponseEntity.ok(libroPublicService.listarLibrosDisponibles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroResponseDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(libroPublicService.buscarPorId(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<LibroResponseDTO>> buscar(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String autor,
            @RequestParam(required = false) String genero) {
        
        if (titulo != null && !titulo.isEmpty()) {
            return ResponseEntity.ok(libroPublicService.buscarPorTitulo(titulo));
        } else if (autor != null && !autor.isEmpty()) {
            return ResponseEntity.ok(libroPublicService.buscarPorAutor(autor));
        } else if (genero != null && !genero.isEmpty()) {
            return ResponseEntity.ok(libroPublicService.buscarPorGenero(genero));
        }
        
        return ResponseEntity.ok(libroPublicService.listarLibrosDisponibles());
    }
}