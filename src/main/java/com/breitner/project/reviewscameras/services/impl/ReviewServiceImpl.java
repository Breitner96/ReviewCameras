package com.breitner.project.reviewscameras.services.impl;

import com.breitner.project.reviewscameras.dto.ReviewDTO;
import com.breitner.project.reviewscameras.dto.database.Autor;
import com.breitner.project.reviewscameras.dto.database.Producto;
import com.breitner.project.reviewscameras.dto.database.Review;
import com.breitner.project.reviewscameras.handler.mapper.ReviewMapper;
import com.breitner.project.reviewscameras.models.ReviewObtenerResponse;
import com.breitner.project.reviewscameras.models.ReviewSaveRequest;
import com.breitner.project.reviewscameras.models.ReviewSaveResponse;
import com.breitner.project.reviewscameras.repository.AutorRepository;
import com.breitner.project.reviewscameras.repository.ProductoRepository;
import com.breitner.project.reviewscameras.repository.ReviewRepository;
import com.breitner.project.reviewscameras.services.IReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ReviewServiceImpl implements IReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    ProductoRepository productoRepository;


    @Autowired
    ReviewMapper reviewMapper;

    @Override
    public ReviewSaveResponse saveReview(ReviewSaveRequest reviewSaveRequest) {

        Autor autor=autorRepository.findById(reviewSaveRequest.getReviewDTO().getIdAutor()).orElse(null);
        Producto producto= productoRepository.findById(reviewSaveRequest.getReviewDTO().getIdProducto()).orElse(null);
        Review review=reviewMapper.dtoToEntity(reviewSaveRequest.getReviewDTO());
        log.info("ReviewDTO: {}",reviewSaveRequest.getReviewDTO());
        review.setAutor(autor);
        review.setProducto(producto);
        log.info("Review: {}",review);


        ReviewDTO reviewDto=reviewMapper.EntitytoDTO(reviewRepository.save(review));
        ReviewSaveResponse reviewSaveResponse =new ReviewSaveResponse();
        reviewSaveResponse.setReviewDTO(reviewDto);

        return reviewSaveResponse;
    }

    @Override
    public List<ReviewObtenerResponse> getAllReviews() {
        List<ReviewDTO> reviewDto=reviewMapper.EntitytoDTOList(reviewRepository.findAll());
        List<ReviewObtenerResponse> reviewObtenerResponse=new ArrayList<>();
        for (int i = 0; i < reviewDto.size(); i++) {
            reviewObtenerResponse.add(new ReviewObtenerResponse());
        }
        final int[] i = {0};
        reviewObtenerResponse.forEach(x->{
            x.setReviewDTO(reviewDto.get(i[0]));
            i[0]++;
        });
        log.info("ReviewResponse, {}: ",reviewObtenerResponse);
        return reviewObtenerResponse;
    }
}
