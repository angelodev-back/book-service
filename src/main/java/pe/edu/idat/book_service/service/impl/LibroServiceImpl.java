package pe.edu.idat.book_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.idat.book_service.dto.request.LibroRequestDTO;
import pe.edu.idat.book_service.dto.request.LibroUpdateDTO;
import pe.edu.idat.book_service.dto.response.EstadisticasDTO;
import pe.edu.idat.book_service.dto.response.LibroBasicoDTO;
import pe.edu.idat.book_service.dto.response.LibroDetalleDTO;
import pe.edu.idat.book_service.dto.response.LibroDisponibilidadDTO;
import pe.edu.idat.book_service.dto.response.LibroResponseDTO;
import pe.edu.idat.book_service.service.ILibroAdminService;
import pe.edu.idat.book_service.service.ILibroBibliotecarioService;
import pe.edu.idat.book_service.service.ILibroInternoService;
import pe.edu.idat.book_service.service.ILibroPublicService;
import pe.edu.idat.book_service.service.ILibroService;



@Service
public class LibroServiceImpl implements ILibroService {

    private final ILibroPublicService publicService;
    private final ILibroBibliotecarioService bibliotecarioService;
    private final ILibroAdminService adminService;
    private final ILibroInternoService internoService;

    public LibroServiceImpl(ILibroPublicService publicService,
                            ILibroBibliotecarioService bibliotecarioService,
                            ILibroAdminService adminService,
                            ILibroInternoService internoService) {
        this.publicService = publicService;
        this.bibliotecarioService = bibliotecarioService;
        this.adminService = adminService;
        this.internoService = internoService;
    }

    @Override public List<LibroResponseDTO> listarLibrosDisponibles() { 
    	return publicService.listarLibrosDisponibles(); 
    }
    
    @Override public LibroResponseDTO buscarPorId(Integer id) { 
    	return publicService.buscarPorId(id); 
    }
    
    @Override public List<LibroResponseDTO> buscarPorTitulo(String titulo) { 
    	return publicService.buscarPorTitulo(titulo); 
    }
    
    @Override public List<LibroResponseDTO> buscarPorAutor(String autor) { 
    	return publicService.buscarPorAutor(autor); 
    }
    
    @Override public List<LibroResponseDTO> buscarPorGenero(String genero) { 
    	return publicService.buscarPorGenero(genero); 
    }

    @Override public List<LibroDetalleDTO> listarTodos() { 
    	return bibliotecarioService.listarTodos(); 
    }
    
    @Override public LibroDetalleDTO buscarPorIdDetalle(Integer id) { 
    	return bibliotecarioService.buscarPorIdDetalle(id); 
    }
    
    @Override public LibroDetalleDTO registrarLibro(LibroRequestDTO dto, String usuario) { 
    	return bibliotecarioService.registrarLibro(dto, usuario); 
    }
    
    @Override public LibroDetalleDTO actualizarLibro(Integer id, LibroUpdateDTO dto, String usuario) { 
    	return bibliotecarioService.actualizarLibro(id, dto, usuario); 
    }
    
    @Override public void ajustarStock(Integer id, Integer cantidad, String motivo, String usuario) { 
    	bibliotecarioService.ajustarStock(id, cantidad, motivo, usuario); 
    }
    
    @Override public void cambiarEstado(Integer id, String estado, String usuario) { 
    	bibliotecarioService.cambiarEstado(id, estado, usuario); 
    }

    @Override public void eliminarLibro(Integer id, String usuario) { 
    	adminService.eliminarLibro(id, usuario); 
    }
    
    @Override public EstadisticasDTO obtenerEstadisticas() { 
    	return adminService.obtenerEstadisticas(); 
    }

    @Override public LibroDisponibilidadDTO validarDisponibilidad(Integer id) { 
    	return internoService.validarDisponibilidad(id); 
    }
    
    @Override public void prestarLibro(Integer id) { 
    	internoService.prestarLibro(id); 
    }
    
    @Override public void devolverLibro(Integer id) { 
    	internoService.devolverLibro(id); 
    }
    
    @Override public LibroBasicoDTO obtenerDatosBasicos(Integer id) { 
    	return internoService.obtenerDatosBasicos(id); 
    }
}