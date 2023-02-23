package com.breitner.project.reviewscameras.controller;

import com.breitner.project.reviewscameras.models.ReviewObtenerResponse;
import com.breitner.project.reviewscameras.models.ReviewSaveRequest;
import com.breitner.project.reviewscameras.models.ReviewSaveResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api/v1/tiendabreit", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Review Controller", description = "This API has a CRUD for Reviews")
public class ReviewController {

    @Autowired
    com.breitner.project.reviewscameras.services.IReviewService IReviewService;

    @PostMapping("/save/review")
    public ResponseEntity<ReviewSaveResponse> saveReview(@RequestBody ReviewSaveRequest reviewSaveRequest){

        ReviewSaveResponse reviewSaveResponse = IReviewService.saveReview(reviewSaveRequest);
        return new ResponseEntity<>(reviewSaveResponse, HttpStatus.OK);
    }

    @GetMapping("/review")
    public List<ReviewObtenerResponse> obtenerAutores(){

        return IReviewService.getAllReviews();
    }
}
