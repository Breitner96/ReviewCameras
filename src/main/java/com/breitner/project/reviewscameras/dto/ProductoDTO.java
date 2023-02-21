package com.breitner.project.reviewscameras.dto;

import com.breitner.project.reviewscameras.dto.database.Caracteristica;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductoDTO {

    @JsonProperty(namespace = "idProducto")
    private Long idProducto;

    @JsonProperty(namespace = "nombre")
    private String nombre;

    @JsonProperty(namespace = "marca")
    private String marca;

    @JsonProperty(namespace = "precio")
    private Double precio;

    @JsonProperty(namespace = "caracteristica")
    private List<Caracteristica> caracteristica;
}
