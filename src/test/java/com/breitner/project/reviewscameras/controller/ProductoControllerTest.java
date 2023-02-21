package com.breitner.project.reviewscameras.controller;

import com.breitner.project.reviewscameras.dto.ProductoDTO;
import com.breitner.project.reviewscameras.dto.database.Caracteristica;
import com.breitner.project.reviewscameras.models.ProductoObtenerResponse;
import com.breitner.project.reviewscameras.services.IProductoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductoController.class)
public class ProductoControllerTest {

    @MockBean
    private IProductoService iProductoService;

    static final String GET_PRODUCT = "/api/v1/tiendabreit/producto";

    @Autowired
    private MockMvc mockMvc;


    @Test
    void obtenerProductoTest () throws Exception {
        when(iProductoService.getAllProducts()).thenReturn(getListProducts());
        mockMvc.perform(MockMvcRequestBuilders.get(GET_PRODUCT)).andExpect(status().isOk()).andReturn();
    }

    List<ProductoObtenerResponse> getListProducts(){
        return List.of(ProductoObtenerResponse.builder()
                .productoDto(ProductoDTO.builder()
                        .idProducto(1L)
                        .nombre("Carro")
                        .marca("NISSAN")
                        .precio(100000000.0)
                        .caracteristica(List.of(Caracteristica.builder()
                                .idCaracteristica(1L)
                                .nombre("Cilindraje")
                                .detalles("1200cc")
                                .build()))
                        .build())
                .build());
    }
}
