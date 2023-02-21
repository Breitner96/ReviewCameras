package com.breitner.project.reviewscameras.services.impl;

import com.breitner.project.reviewscameras.dto.AutorDTO;
import com.breitner.project.reviewscameras.dto.database.Autor;
import com.breitner.project.reviewscameras.handler.mapper.AutorMapper;
import com.breitner.project.reviewscameras.models.AutorObtenerResponse;
import com.breitner.project.reviewscameras.models.AutorSaveRequest;
import com.breitner.project.reviewscameras.models.AutorSaveResponse;
import com.breitner.project.reviewscameras.repository.AutorRepository;
import com.breitner.project.reviewscameras.services.IAutorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AutorServiceImpl implements IAutorService {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    AutorMapper autorMapper;

    @Override
    public AutorSaveResponse saveAutor(AutorSaveRequest autorSaveRequest) {

        Autor autor=autorMapper.dtoToEntity(autorSaveRequest.getAutorDto());

        log.info("Autor: {}",autor);

        AutorDTO autorDto=autorMapper.EntitytoDTO(autorRepository.save(autor));
        AutorSaveResponse autorSaveResponse =new AutorSaveResponse();
        autorSaveResponse.setAutorDto(autorDto);

        return autorSaveResponse;
    }

    @Override
    public List<AutorObtenerResponse> getAllAutor() {
        List<AutorDTO> autorDto=autorMapper.EntitytoDTOList( autorRepository.findAll());
        List<AutorObtenerResponse> autorObtenerResponse=new ArrayList<>();
        for (int i = 0; i < autorDto.size(); i++) {
            autorObtenerResponse.add(new AutorObtenerResponse());
        }
        final int[] i = {0};
        autorObtenerResponse.forEach(x->{
            x.setAutorDto(autorDto.get(i[0]));
            i[0]++;
        });
        log.info("autorResponse, {}: ",autorObtenerResponse);
        return autorObtenerResponse;
    }
}
