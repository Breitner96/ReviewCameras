package com.platzi.platzireviewscameras.repository;

import com.platzi.platzireviewscameras.dto.database.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
