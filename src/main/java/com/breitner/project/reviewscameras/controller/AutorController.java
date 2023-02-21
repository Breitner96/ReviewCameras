package com.breitner.project.reviewscameras.controller;

import com.breitner.project.reviewscameras.models.AutorSaveRequest;
import com.breitner.project.reviewscameras.models.AutorSaveResponse;
import com.breitner.project.reviewscameras.services.IAutorService;
import com.breitner.project.reviewscameras.models.AutorObtenerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api/v1/tiendabreit", produces = MediaType.APPLICATION_JSON_VALUE)
public class AutorController {

    @Autowired
    IAutorService IautorServiceImpl;

    @PostMapping("/save/autor")
    public ResponseEntity<AutorSaveResponse> saveAutor(@RequestBody AutorSaveRequest autorSaveRequest){

        AutorSaveResponse autorSaveResponse = IautorServiceImpl.saveAutor(autorSaveRequest);
        return new ResponseEntity<>(autorSaveResponse, HttpStatus.OK);
    }

    @GetMapping("/autor")
    public List<AutorObtenerResponse> obtenerAutores(){

        return IautorServiceImpl.getAllAutor();
    }
}
