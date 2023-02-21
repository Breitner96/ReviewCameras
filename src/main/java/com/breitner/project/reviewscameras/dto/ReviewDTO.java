package com.breitner.project.reviewscameras.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.breitner.project.reviewscameras.dto.database.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewDTO {

    @JsonProperty(namespace = "idReview")
    private Long idReview;

    @JsonProperty(namespace = "titulo")
    private String titulo;

    @JsonProperty(namespace = "contenido")
    private String contenido;

    @JsonProperty(namespace = "idAutor")
    private Long idAutor;

    @JsonProperty(namespace = "idProducto")
    private Long idProducto;

    @JsonProperty(namespace = "autorDto")
    private AutorDTO autorDto;

    @JsonProperty(namespace = "producto")
    private Producto producto;
}
