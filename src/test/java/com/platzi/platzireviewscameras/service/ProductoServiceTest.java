package com.platzi.platzireviewscameras.service;

import com.platzi.platzireviewscameras.handler.mapper.ProductoMapper;
import com.platzi.platzireviewscameras.models.ProductoObtenerResponse;
import com.platzi.platzireviewscameras.repository.ProductoRepository;
import com.platzi.platzireviewscameras.services.ProductoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoServiceTest {

    @Mock
    ProductoRepository productoRepository;

    @Mock
    ProductoMapper productoMapper;


    @InjectMocks
    private ProductoServiceImpl productoServiceImpl;
    private List<ProductoObtenerResponse> productoObtenerResponse = new ArrayList<>();


    @BeforeEach
    private void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void productoObtenerTest() {

        List<ProductoObtenerResponse> response = productoServiceImpl.getAllProducts();

        assertEquals(productoObtenerResponse,response);
    }
}
