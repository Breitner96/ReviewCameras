package com.platzi.platzireviewscameras.controller;

import com.platzi.platzireviewscameras.models.ReviewSaveRequest;
import com.platzi.platzireviewscameras.models.ReviewSaveResponse;
import com.platzi.platzireviewscameras.services.IReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReviewControllerTest {

    @Mock
    private IReviewService iReviewService;

    @InjectMocks
    private ReviewController reviewController;

    @InjectMocks
    private ReviewSaveRequest reviewSaveRequest;
    private ReviewSaveResponse reviewSaveResponse = new ReviewSaveResponse();

    @BeforeEach
    private void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveReviewTest () {
        Mockito.when(
                        iReviewService.saveReview(reviewSaveRequest))
                .thenReturn(reviewSaveResponse);

        ResponseEntity<ReviewSaveResponse> response = reviewController.saveReview(reviewSaveRequest);
        assertEquals(reviewSaveResponse, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode().OK);
    }

}
