package com.breitner.project.reviewscameras.controller;

import com.breitner.project.reviewscameras.models.ProductoObtenerResponse;
import com.breitner.project.reviewscameras.services.IProductoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/api/v1/tiendabreit", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Product Controller", description = "This API has a CRUD for Products")
public class ProductoController {

    @Autowired
    IProductoService iProductoService;

    @GetMapping("/product")
    public ResponseEntity<List<ProductoObtenerResponse>> obtenerProductos(){

        return new ResponseEntity<>(iProductoService.getAllProducts(), HttpStatus.OK);
    }
}
