package com.breitner.project.reviewscameras.handler.mapper;

import com.breitner.project.reviewscameras.dto.ReviewDTO;
import com.breitner.project.reviewscameras.dto.database.Review;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = AutorMapper.class)
public interface ReviewMapper {

    @Mappings({
            @Mapping(target = "autor",ignore = true),
            @Mapping(target = "producto",ignore = true)
    })
    Review dtoToEntity(ReviewDTO reviewDTO);

    @Mappings({
            @Mapping(target = "idAutor",ignore = true),
            @Mapping(target = "idProducto",ignore = true),
            @Mapping(source = "autor",target = "autorDto")
    })
    ReviewDTO EntitytoDTO(Review review);

    @Mapping(source = "autor",target = "autorDto")
    List<ReviewDTO> EntitytoDTOList(List<Review> review);
}
