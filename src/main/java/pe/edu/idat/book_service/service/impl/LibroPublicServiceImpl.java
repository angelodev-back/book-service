package pe.edu.idat.book_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.idat.book_service.dto.response.LibroResponseDTO;
import pe.edu.idat.book_service.entity.Libro;
import pe.edu.idat.book_service.exception.LibroNotFoundException;
import pe.edu.idat.book_service.mapper.LibroMapper;
import pe.edu.idat.book_service.repostory.LibroBaseRepository;
import pe.edu.idat.book_service.repostory.LibroPublicRepository;
import pe.edu.idat.book_service.service.ILibroPublicService;

@Service
public class LibroPublicServiceImpl implements ILibroPublicService {

    private final LibroBaseRepository baseRepository;
    private final LibroPublicRepository publicRepository;
    private final LibroMapper libroMapper;

    public LibroPublicServiceImpl(LibroBaseRepository baseRepository,
                                  LibroPublicRepository publicRepository,
                                  LibroMapper libroMapper) {
        this.baseRepository = baseRepository;
        this.publicRepository = publicRepository;
        this.libroMapper = libroMapper;
    }

    @Override
    public List<LibroResponseDTO> listarLibrosDisponibles() {
        List<Libro> libros = publicRepository.findAllActivosConStock();
        return libroMapper.toResponseDTOList(libros);
    }

    @Override
    public LibroResponseDTO buscarPorId(Integer id) {
        Libro libro = baseRepository.findById(id)
                .orElseThrow(() -> new LibroNotFoundException("Libro no encontrado con ID: " + id));
        if (!"ACTIVO".equals(libro.getEstado())) {
            throw new LibroNotFoundException("Libro no disponible");
        }
        return libroMapper.toResponseDTO(libro);
    }

    @Override
    public List<LibroResponseDTO> buscarPorTitulo(String titulo) {
        List<Libro> libros = publicRepository.buscarPorTitulo(titulo);
        return libroMapper.toResponseDTOList(libros);
    }

    @Override
    public List<LibroResponseDTO> buscarPorAutor(String autor) {
        List<Libro> libros = publicRepository.buscarPorAutor(autor);
        return libroMapper.toResponseDTOList(libros);
    }

    @Override
    public List<LibroResponseDTO> buscarPorGenero(String genero) {
        List<Libro> libros = publicRepository.buscarPorGenero(genero);
        return libroMapper.toResponseDTOList(libros);
    }
}