package com.breitner.project.reviewscameras.services;

import com.breitner.project.reviewscameras.models.ProductoObtenerResponse;

import java.util.List;

public interface IProductoService {

    List<ProductoObtenerResponse> getAllProducts();
}
