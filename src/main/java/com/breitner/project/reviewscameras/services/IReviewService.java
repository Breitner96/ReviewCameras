package com.breitner.project.reviewscameras.services;

import com.breitner.project.reviewscameras.models.ReviewObtenerResponse;
import com.breitner.project.reviewscameras.models.ReviewSaveRequest;
import com.breitner.project.reviewscameras.models.ReviewSaveResponse;

import java.util.List;

public interface IReviewService {

    ReviewSaveResponse saveReview(ReviewSaveRequest reviewSaveRequest);
    List<ReviewObtenerResponse> getAllReviews();
}
