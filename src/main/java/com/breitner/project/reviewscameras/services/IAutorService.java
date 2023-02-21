package com.breitner.project.reviewscameras.services;

import com.breitner.project.reviewscameras.models.AutorSaveRequest;
import com.breitner.project.reviewscameras.models.AutorSaveResponse;
import com.breitner.project.reviewscameras.models.AutorObtenerResponse;

import java.util.List;

public interface IAutorService {

    AutorSaveResponse saveAutor(AutorSaveRequest autorSaveRequest);
    List<AutorObtenerResponse> getAllAutor();
}
