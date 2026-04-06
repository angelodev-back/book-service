package pe.edu.idat.book_service.controller;

import pe.edu.idat.book_service.entity.Libro;
import pe.edu.idat.book_service.service.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // =========================
    // REGISTRAR
    // =========================
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.guardar(libro));
    }

    // =========================
    // LISTAR TODOS
    // =========================
    @GetMapping
    public List<Libro> listar() {
        return libroService.listarTodos();
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    @GetMapping("/{id}")
    public Libro obtener(@PathVariable Integer id) {
        return libroService.buscarPorId(id);
    }

    // =========================
    // BUSCAR POR GENERO
    // =========================
    @GetMapping("/genero/{genero}")
    public List<Libro> buscarGenero(@PathVariable String genero) {
        return libroService.buscarPorGenero(genero);
    }

    // =========================
    // BUSCAR POR TITULO
    // =========================
    @GetMapping("/titulo/{titulo}")
    public List<Libro> buscarTitulo(@PathVariable String titulo) {
        return libroService.buscarPorTitulo(titulo);
    }

    // =========================
    // BUSCAR POR AUTOR
    // =========================
    @GetMapping("/autor/{autor}")
    public List<Libro> buscarAutor(@PathVariable String autor) {
        return libroService.buscarPorAutor(autor);
    }

    // =========================
    // DISPONIBLES
    // =========================
    @GetMapping("/disponibles")
    public List<Libro> disponibles() {
        return libroService.listarDisponibles();
    }

    // =========================
    // ACTUALIZAR
    // =========================
    @PutMapping("/{id}")
    public Libro actualizar(@PathVariable Integer id, @RequestBody Libro libro) {
        return libroService.actualizar(id, libro);
    }
}