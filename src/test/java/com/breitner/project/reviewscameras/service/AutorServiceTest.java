package com.breitner.project.reviewscameras.service;

import com.breitner.project.reviewscameras.dto.AutorDTO;
import com.breitner.project.reviewscameras.dto.database.Autor;
import com.breitner.project.reviewscameras.services.impl.AutorServiceImpl;
import com.breitner.project.reviewscameras.handler.mapper.AutorMapper;
import com.breitner.project.reviewscameras.models.AutorSaveRequest;
import com.breitner.project.reviewscameras.repository.AutorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class AutorServiceTest {

    @Mock
    AutorRepository autorRepository;

    @Mock
    AutorMapper autorMapper;

    @InjectMocks
    private AutorServiceImpl autorServiceImpl;

    @Test
    public void autorSaveTest() {

        when(autorMapper.dtoToEntity(any())).thenReturn(getAutor());
        when(autorMapper.EntitytoDTO(any())).thenReturn(getAutorDto());

        assertEquals("breitner", autorServiceImpl.saveAutor(getAutorSaveRequest()).getAutorDto().getNombre());
    }

    @Test
    public void autorGetTest() {

        when(autorMapper.EntitytoDTOList(any())).thenReturn(getListAutorDto());
        when(autorMapper.EntitytoDTO(any())).thenReturn(getAutorDto());

        assertEquals(1, autorServiceImpl.getAllAutor().size());
    }

    Autor getAutor() {
        return  Autor.builder()
                .idAutor(1L)
                .nombre("breitner")
                .telefono("3105258589")
                .email("emailfalsogmail.com")
                .pais("Colombia")
                .build();
    }

    AutorDTO getAutorDto() {
        return  AutorDTO.builder()
                .nombre("breitner")
                .telefono("3105258589")
                .email("emailfalsogmail.com")
                .pais("Colombia")
                .build();
    }

    AutorSaveRequest getAutorSaveRequest(){
        return AutorSaveRequest.builder()
                .autorDto(AutorDTO.builder()
                        .nombre("breitner")
                        .telefono("3105258589")
                        .email("emailfalsogmail.com")
                        .pais("Colombia")
                        .build())
                .build();
    }

    List<AutorDTO> getListAutorDto(){
        return List.of(getAutorDto());
    }


}
