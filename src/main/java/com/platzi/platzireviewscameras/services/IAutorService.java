package com.platzi.platzireviewscameras.services;

import com.platzi.platzireviewscameras.models.AutorObtenerResponse;
import com.platzi.platzireviewscameras.models.AutorSaveRequest;
import com.platzi.platzireviewscameras.models.AutorSaveResponse;

import java.util.List;

public interface IAutorService {

    AutorSaveResponse saveAutor(AutorSaveRequest autorSaveRequest);
    List<AutorObtenerResponse> getAllAutor();
}
