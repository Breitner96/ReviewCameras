package com.platzi.platzireviewscameras.services;

import com.platzi.platzireviewscameras.models.*;

import java.util.List;

public interface IReviewService {

    ReviewSaveResponse saveReview(ReviewSaveRequest reviewSaveRequest);
    List<ReviewObtenerResponse> getAllReviews();
}
