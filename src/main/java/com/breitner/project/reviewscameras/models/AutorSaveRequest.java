package com.breitner.project.reviewscameras.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.breitner.project.reviewscameras.dto.AutorDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutorSaveRequest {

    @JsonProperty("autorDto")
    private AutorDTO autorDto;
}
