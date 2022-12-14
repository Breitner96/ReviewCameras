package com.platzi.platzireviewscameras.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.platzi.platzireviewscameras.dto.AutorDTO;
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
