package com.breitner.project.reviewscameras.service;

import com.breitner.project.reviewscameras.dto.AutorDTO;
import com.breitner.project.reviewscameras.dto.ProductoDTO;
import com.breitner.project.reviewscameras.dto.ReviewDTO;
import com.breitner.project.reviewscameras.dto.database.Autor;
import com.breitner.project.reviewscameras.dto.database.Caracteristica;
import com.breitner.project.reviewscameras.dto.database.Producto;
import com.breitner.project.reviewscameras.dto.database.Review;
import com.breitner.project.reviewscameras.handler.mapper.ReviewMapper;
import com.breitner.project.reviewscameras.models.ReviewSaveRequest;
import com.breitner.project.reviewscameras.models.ReviewSaveResponse;
import com.breitner.project.reviewscameras.repository.AutorRepository;
import com.breitner.project.reviewscameras.repository.ProductoRepository;
import com.breitner.project.reviewscameras.repository.ReviewRepository;
import com.breitner.project.reviewscameras.services.impl.ReviewServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ReviewServiceTest {

    @Mock
    ReviewRepository reviewRepository;

    @Mock
    AutorRepository autorRepository;

    @Mock
    ProductoRepository productoRepository;

    @Mock
    ReviewMapper reviewMapper;

    @InjectMocks
    private ReviewServiceImpl reviewServiceImpl;

    @Test
    public void reviewSaveTest() {

        // given
        when(autorRepository.findById(anyLong())).thenReturn(Optional.of(getAutor()));
        when(productoRepository.findById(anyLong())).thenReturn(Optional.of(getProducto()));
        when(reviewMapper.dtoToEntity(any())).thenReturn(getReview());
        when(reviewMapper.EntitytoDTO(any())).thenReturn(getReviewDto());
        assertEquals("breitner",reviewServiceImpl.saveReview(getReviewSaveRequest()).getReviewDTO().getAutorDto().getNombre());
    }

    @Test
    public void reviewGetTest() {

        // given
        when(reviewMapper.EntitytoDTOList(any())).thenReturn(getListReviewDTO());
        assertEquals(1,reviewServiceImpl.getAllReviews().size());
    }

    Autor getAutor() {
        return  Autor.builder()
                .idAutor(1L)
                .nombre("breitner")
                .telefono("3105258589")
                .email("emailfalsogmail.com")
                .pais("Colombia")
                .build();
    }

    Producto getProducto(){
        return Producto.builder()
                .idProducto(1L)
                .nombre("Carro")
                .marca("NISSAN")
                .precio(100000000.0)
                .caracteristica(List.of(Caracteristica.builder()
                        .idCaracteristica(1L)
                        .nombre("Cilindraje")
                        .detalles("1200cc")
                        .build()))
                .build();
    }

    Review getReview(){
        return Review.builder()
                .idReview(1L)
                .titulo("Carro perfecto")
                .contenido("Carro en excelentes condiciones")
                .autor(Autor.builder()
                        .idAutor(1L)
                        .nombre("breitner")
                        .telefono("3105258589")
                        .email("emailfalsogmail.com")
                        .pais("Colombia")
                        .build())
                .build();
    }

    ReviewDTO getReviewDto(){
        return ReviewDTO.builder()
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
                .build();
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

    List<ReviewDTO> getListReviewDTO(){
        return List.of(getReviewDto());
    }
}
