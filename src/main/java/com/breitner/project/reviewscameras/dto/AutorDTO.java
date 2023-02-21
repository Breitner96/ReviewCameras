package com.breitner.project.reviewscameras.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutorDTO {

    @JsonProperty("idAutor")
    private Long idAutor;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("email")
    private String email;
    @JsonProperty("pais")
    private String pais;
}
