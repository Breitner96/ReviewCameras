package com.platzi.platzireviewscameras.handler.mapper;

import com.platzi.platzireviewscameras.dto.ProductoDTO;
import com.platzi.platzireviewscameras.dto.database.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductoMapper {

    ProductoDTO EntitytoDTO(Producto producto);

    List<ProductoDTO> EntitytoDTOList(List<Producto> productos);
}
