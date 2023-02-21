package com.breitner.project.reviewscameras.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.breitner.project.reviewscameras.dto.ReviewDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewSaveRequest {

    @JsonProperty("reviewDto")
    private ReviewDTO reviewDTO;

}
