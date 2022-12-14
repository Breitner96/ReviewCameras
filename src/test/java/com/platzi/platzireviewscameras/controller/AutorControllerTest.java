package com.platzi.platzireviewscameras.controller;

import com.platzi.platzireviewscameras.models.AutorSaveRequest;
import com.platzi.platzireviewscameras.models.AutorSaveResponse;
import com.platzi.platzireviewscameras.services.IAutorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutorControllerTest {

    @Mock
    private IAutorService iAutorService;

    @InjectMocks
    private AutorController autorController;

    private AutorSaveRequest autorSaveRequest;
    private AutorSaveResponse autorSaveResponse = new AutorSaveResponse();

    @BeforeEach
    private void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveAutorTest () {
        Mockito.when(
                        iAutorService.saveAutor(autorSaveRequest))
                .thenReturn(autorSaveResponse);

        ResponseEntity<AutorSaveResponse> response = autorController.saveAutor(autorSaveRequest);
        assertEquals(autorSaveResponse, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode().OK);
    }



}
