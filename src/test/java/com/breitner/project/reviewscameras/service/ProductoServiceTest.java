package com.breitner.project.reviewscameras.service;

import com.breitner.project.reviewscameras.dto.ProductoDTO;
import com.breitner.project.reviewscameras.dto.database.Caracteristica;
import com.breitner.project.reviewscameras.handler.mapper.ProductoMapper;
import com.breitner.project.reviewscameras.repository.ProductoRepository;
import com.breitner.project.reviewscameras.services.impl.ProductoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ProductoServiceTest {

    @Mock
    ProductoRepository productoRepository;

    @Mock
    ProductoMapper productoMapper;

    @InjectMocks
    private ProductoServiceImpl productoServiceImpl;


    @Test
    public void getAllProducts() {

        when(productoMapper.EntitytoDTOList(any())).thenReturn(getListProducts());
        assertEquals(1, productoServiceImpl.getAllProducts().size());

    }

    List<ProductoDTO> getListProducts(){
        return List.of(ProductoDTO.builder()
                .idProducto(1L)
                .nombre("Carro")
                .marca("NISSAN")
                .precio(100000000.0)
                .caracteristica(List.of(Caracteristica.builder()
                        .idCaracteristica(1L)
                        .nombre("Cilindraje")
                        .detalles("1200cc")
                        .build()))
                .build());
    }
}
