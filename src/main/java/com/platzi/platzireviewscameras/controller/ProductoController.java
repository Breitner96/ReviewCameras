package com.platzi.platzireviewscameras.controller;

import com.platzi.platzireviewscameras.models.ProductoObtenerResponse;
import com.platzi.platzireviewscameras.services.IProductoService;
import com.platzi.platzireviewscameras.services.ProductoServiceImpl;
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
public class ProductoController {

    @Autowired
    IProductoService iProductoService;

    @GetMapping("/producto")
    public ResponseEntity<List<ProductoObtenerResponse>> obtenerProductos(){

        return new ResponseEntity<>(iProductoService.getAllProducts(), HttpStatus.OK);
    }
}
