package com.breitner.project.reviewscameras.service;

import com.breitner.project.reviewscameras.handler.mapper.ProductoMapper;
import com.breitner.project.reviewscameras.models.ProductoObtenerResponse;
import com.breitner.project.reviewscameras.repository.ProductoRepository;
import com.breitner.project.reviewscameras.services.impl.ProductoServiceImpl;
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
