package com.breitner.project.reviewscameras.models;

import com.breitner.project.reviewscameras.dto.ProductoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoObtenerResponse {

    private ProductoDTO productoDto;
}
