package pe.edu.idat.book_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.idat.book_service.dto.response.LibroBasicoDTO;
import pe.edu.idat.book_service.dto.response.LibroDisponibilidadDTO;
import pe.edu.idat.book_service.service.ILibroInternoService;

@RestController
@RequestMapping("/api/internal/libros")
public class LibroInternoController {

    private final ILibroInternoService libroInternoService;

    public LibroInternoController(ILibroInternoService libroInternoService) {
        this.libroInternoService = libroInternoService;
    }

    @GetMapping("/{id}/validar")
    public ResponseEntity<LibroDisponibilidadDTO> validarDisponibilidad(@PathVariable Integer id) {
        return ResponseEntity.ok(libroInternoService.validarDisponibilidad(id));
    }

    @PostMapping("/{id}/prestar")
    public ResponseEntity<Void> prestarLibro(@PathVariable Integer id) {
    	libroInternoService.prestarLibro(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/devolver")
    public ResponseEntity<Void> devolverLibro(@PathVariable Integer id) {
    	libroInternoService.devolverLibro(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/basico")
    public ResponseEntity<LibroBasicoDTO> obtenerDatosBasicos(@PathVariable Integer id) {
        return ResponseEntity.ok(libroInternoService.obtenerDatosBasicos(id));
    }
}