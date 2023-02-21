package com.breitner.project.reviewscameras.service;

import com.breitner.project.reviewscameras.handler.mapper.ReviewMapper;
import com.breitner.project.reviewscameras.models.ReviewSaveRequest;
import com.breitner.project.reviewscameras.models.ReviewSaveResponse;
import com.breitner.project.reviewscameras.repository.AutorRepository;
import com.breitner.project.reviewscameras.repository.ProductoRepository;
import com.breitner.project.reviewscameras.repository.ReviewRepository;
import com.breitner.project.reviewscameras.services.impl.ReviewServiceImpl;
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
