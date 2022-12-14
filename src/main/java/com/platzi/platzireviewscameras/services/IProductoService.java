package com.platzi.platzireviewscameras.services;

import com.platzi.platzireviewscameras.models.ProductoObtenerResponse;

import java.util.List;

public interface IProductoService {

    List<ProductoObtenerResponse> getAllProducts();
}
