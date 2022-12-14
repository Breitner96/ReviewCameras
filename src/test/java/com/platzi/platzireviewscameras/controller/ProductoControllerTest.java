package com.platzi.platzireviewscameras.controller;

import com.platzi.platzireviewscameras.models.ProductoObtenerResponse;
import com.platzi.platzireviewscameras.services.IProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoControllerTest {

    @Mock
    private IProductoService iProductoService;

    @InjectMocks
    private ProductoController productoController;

    @InjectMocks
    private List<ProductoObtenerResponse> productoObtenerResponse = new ArrayList<>();

    @BeforeEach
    private void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void obtenerProductoTest () {
        Mockito.when(
                        iProductoService.getAllProducts())
                .thenReturn(productoObtenerResponse);

        ResponseEntity<List<ProductoObtenerResponse>> response = productoController.obtenerProductos();
        assertEquals(productoObtenerResponse, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode().OK);
    }
}
