package com.breitner.project.reviewscameras.service;

import com.breitner.project.reviewscameras.services.impl.AutorServiceImpl;
import com.breitner.project.reviewscameras.handler.mapper.AutorMapper;
import com.breitner.project.reviewscameras.models.AutorSaveRequest;
import com.breitner.project.reviewscameras.models.AutorSaveResponse;
import com.breitner.project.reviewscameras.repository.AutorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
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
