package com.breitner.project.reviewscameras.controller;

import com.breitner.project.reviewscameras.dto.AutorDTO;
import com.breitner.project.reviewscameras.dto.ReviewDTO;
import com.breitner.project.reviewscameras.dto.database.Caracteristica;
import com.breitner.project.reviewscameras.dto.database.Producto;
import com.breitner.project.reviewscameras.models.ReviewObtenerResponse;
import com.breitner.project.reviewscameras.models.ReviewSaveRequest;
import com.breitner.project.reviewscameras.models.ReviewSaveResponse;
import com.breitner.project.reviewscameras.services.IReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {

    @MockBean
    private IReviewService iReviewService;

    static final String SAVE_REVIEW= "/api/v1/tiendabreit/save/review";
    static final String GET_REVIEW = "/api/v1/tiendabreit/review";

    @Autowired
    private MockMvc mockMvc;


    @Test
    void saveReviewTest () throws Exception {
        when(iReviewService.saveReview(any())).thenReturn(getReviewSaveResponse());

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.post(SAVE_REVIEW)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(getReviewSaveRequest()))).andExpect(
                status().isOk());
    }
    @Test
    void getReviewTest () throws Exception {
        when(iReviewService.getAllReviews()).thenReturn(getListReviewObtenerResponse());
        mockMvc.perform(MockMvcRequestBuilders.get(GET_REVIEW)).andExpect(status().isOk()).andReturn();
    }


    ReviewSaveRequest getReviewSaveRequest(){
        return ReviewSaveRequest.builder()
                .reviewDTO(ReviewDTO.builder()
                        .idReview(1L)
                        .titulo("Carro perfecto")
                        .contenido("Carro en excelentes condiciones")
                        .idAutor(1L)
                        .idProducto(1L)
                        .build())
                .build();
    }

    ReviewSaveResponse getReviewSaveResponse(){
        return ReviewSaveResponse.builder()
                .reviewDTO(ReviewDTO.builder()
                        .idReview(1L)
                        .titulo("Carro perfecto")
                        .contenido("Carro en excelentes condiciones")
                        .autorDto(AutorDTO.builder()
                                .idAutor(1L)
                                .nombre("breitner")
                                .telefono("3105258589")
                                .email("emailfalsogmail.com")
                                .pais("Colombia")
                                .build())
                        .producto(Producto.builder()
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
                        .build())
                .build();
    }

    List<ReviewObtenerResponse> getListReviewObtenerResponse(){
        return List.of(ReviewObtenerResponse.builder().reviewDTO(getReviewSaveResponse().getReviewDTO()).build());
    }



}
