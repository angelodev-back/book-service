package pe.edu.idat.book_service.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pe.edu.idat.book_service.dto.request.LibroRequestDTO;
import pe.edu.idat.book_service.dto.request.LibroUpdateDTO;
import pe.edu.idat.book_service.dto.response.LibroDetalleDTO;
import pe.edu.idat.book_service.entity.Libro;
import pe.edu.idat.book_service.exception.IsbnDuplicadoException;
import pe.edu.idat.book_service.exception.LibroNotFoundException;
import pe.edu.idat.book_service.exception.StockInsuficienteException;
import pe.edu.idat.book_service.mapper.LibroMapper;
import pe.edu.idat.book_service.repostory.LibroBaseRepository;
import pe.edu.idat.book_service.repostory.LibroBibliotecarioRepository;
import pe.edu.idat.book_service.service.ILibroBibliotecarioService;

@Service
public class LibroBibliotecarioServiceImpl implements ILibroBibliotecarioService {

    private final LibroBaseRepository baseRepository;
    private final LibroBibliotecarioRepository bibliotecarioRepository;
    private final LibroMapper libroMapper;

    public LibroBibliotecarioServiceImpl(LibroBaseRepository baseRepository,
                                         LibroBibliotecarioRepository bibliotecarioRepository,
                                         LibroMapper libroMapper) {
        this.baseRepository = baseRepository;
        this.bibliotecarioRepository = bibliotecarioRepository;
        this.libroMapper = libroMapper;
    }

    @Override
    public List<LibroDetalleDTO> listarTodos() {
        List<Libro> libros = bibliotecarioRepository.findAllLibros();
        return libroMapper.toDetalleDTOList(libros);
    }

    @Override
    public LibroDetalleDTO buscarPorIdDetalle(Integer id) {
        Libro libro = baseRepository.findById(id)
                .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado con ID: " + id));
        return libroMapper.toDetalleDTO(libro);
    }

    @Override
    @Transactional
    public LibroDetalleDTO registrarLibro(LibroRequestDTO dto, String usuario) {
        if (baseRepository.existsByIsbn(dto.getIsbn())) {
            throw new IsbnDuplicadoException("El ISBN ya está registrado");
        }
        Libro libro = libroMapper.requestToEntity(dto);
        libro.setEstado("ACTIVO");
        libro.setCreatedBy(usuario);
        libro.setCreatedDate(LocalDateTime.now());
        Libro saved = baseRepository.save(libro);
        return libroMapper.toDetalleDTO(saved);
    }

    @Override
    @Transactional
    public LibroDetalleDTO actualizarLibro(Integer id, LibroUpdateDTO dto, String usuario) {
        Libro libro = baseRepository.findById(id)
                .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado con ID: " + id));
        if (baseRepository.existsByIsbnAndIdNot(dto.getIsbn(), id)) {
            throw new IsbnDuplicadoException("El ISBN ya está registrado por otro libro");
        }
        libroMapper.updateEntityFromDto(dto, libro);
        libro.setModifiedBy(usuario);
        libro.setLastModifiedDate(LocalDateTime.now());
        Libro updated = baseRepository.save(libro);
        return libroMapper.toDetalleDTO(updated);
    }

    @Override
    @Transactional
    public void ajustarStock(Integer id, Integer cantidad, String motivo, String usuario) {
        Libro libro = baseRepository.findById(id)
                .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado con ID: " + id));
        int nuevoStock = libro.getStock() + cantidad;
        if (nuevoStock < 0) {
            throw new StockInsuficienteException("Stock insuficiente. Stock actual: " + libro.getStock());
        }
        libro.setStock(nuevoStock);
        libro.setModifiedBy(usuario + (motivo != null ? " - " + motivo : ""));
        libro.setLastModifiedDate(LocalDateTime.now());
        baseRepository.save(libro);
    }

    @Override
    @Transactional
    public void cambiarEstado(Integer id, String estado, String usuario) {
        Libro libro = baseRepository.findById(id)
                .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado con ID: " + id));
        libro.setEstado(estado);
        libro.setModifiedBy(usuario);
        libro.setLastModifiedDate(LocalDateTime.now());
        baseRepository.save(libro);
    }
}