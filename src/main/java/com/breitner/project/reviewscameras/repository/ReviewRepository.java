package com.breitner.project.reviewscameras.repository;

import com.breitner.project.reviewscameras.dto.database.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
