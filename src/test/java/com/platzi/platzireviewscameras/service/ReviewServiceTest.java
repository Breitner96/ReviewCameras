package com.platzi.platzireviewscameras.service;

import com.platzi.platzireviewscameras.handler.mapper.ReviewMapper;
import com.platzi.platzireviewscameras.models.ReviewSaveRequest;
import com.platzi.platzireviewscameras.models.ReviewSaveResponse;
import com.platzi.platzireviewscameras.repository.AutorRepository;
import com.platzi.platzireviewscameras.repository.ProductoRepository;
import com.platzi.platzireviewscameras.repository.ReviewRepository;
import com.platzi.platzireviewscameras.services.ReviewServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReviewServiceTest {

    @Mock
    ReviewRepository reviewRepository;

    @Mock
    AutorRepository autorRepository;

    @Mock
    ProductoRepository productoRepository;

    @Mock
    ReviewMapper reviewMapper;


    @Mock
    private ReviewServiceImpl reviewServiceImpl;

    @InjectMocks
    ReviewSaveResponse reviewSaveResponse;

    @InjectMocks
    ReviewSaveRequest reviewSaveRequest;


    @BeforeEach
    private void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void reviewSaveTest() {

        // given
        when(reviewServiceImpl.saveReview(reviewSaveRequest)).thenReturn(reviewSaveResponse);
        ReviewSaveResponse response = reviewServiceImpl.saveReview(reviewSaveRequest);
        assertEquals(reviewSaveResponse,response);
    }
}
