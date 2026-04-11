package pe.edu.idat.book_service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import pe.edu.idat.book_service.dto.request.LibroRequestDTO;
import pe.edu.idat.book_service.dto.request.LibroUpdateDTO;
import pe.edu.idat.book_service.dto.response.LibroBasicoDTO;
import pe.edu.idat.book_service.dto.response.LibroDetalleDTO;
import pe.edu.idat.book_service.dto.response.LibroResponseDTO;
import pe.edu.idat.book_service.entity.Libro;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LibroMapper {

    @Mapping(target = "idLibro", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    Libro requestToEntity(LibroRequestDTO dto);

    LibroResponseDTO toResponseDTO(Libro libro);
    List<LibroResponseDTO> toResponseDTOList(List<Libro> libros);

    LibroDetalleDTO toDetalleDTO(Libro libro);
    List<LibroDetalleDTO> toDetalleDTOList(List<Libro> libros);

    LibroBasicoDTO toBasicoDTO(Libro libro);

    @Mapping(target = "idLibro", ignore = true)
    @Mapping(target = "stock", ignore = true)
    @Mapping(target = "estado", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "modifiedBy", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    void updateEntityFromDto(LibroUpdateDTO dto, @MappingTarget Libro libro);
}