package com.breitner.project.reviewscameras.handler.mapper;

import com.breitner.project.reviewscameras.dto.ProductoDTO;
import com.breitner.project.reviewscameras.dto.database.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductoMapper {

    ProductoDTO EntitytoDTO(Producto producto);

    List<ProductoDTO> EntitytoDTOList(List<Producto> productos);
}
