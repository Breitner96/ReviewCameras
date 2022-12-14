package com.platzi.platzireviewscameras.service;

import com.platzi.platzireviewscameras.handler.mapper.AutorMapper;
import com.platzi.platzireviewscameras.models.AutorSaveRequest;
import com.platzi.platzireviewscameras.models.AutorSaveResponse;
import com.platzi.platzireviewscameras.repository.AutorRepository;
import com.platzi.platzireviewscameras.services.AutorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class AutorServiceTest {

    @Mock
    AutorRepository autorRepository;

    @Mock
    AutorMapper autorMapper;


    @InjectMocks
    private AutorServiceImpl autorServiceImpl;
    private AutorSaveResponse autorSaveResponse;

    @InjectMocks
    private AutorSaveRequest autorSaveRequest;

    @BeforeEach
    private void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void autorSaveTest() {

        autorSaveResponse = new AutorSaveResponse();

        AutorSaveResponse response = autorServiceImpl.saveAutor(autorSaveRequest);

        assertEquals(autorSaveResponse,response);
    }


}
