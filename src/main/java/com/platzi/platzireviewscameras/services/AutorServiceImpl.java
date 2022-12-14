package com.platzi.platzireviewscameras.services;

import com.platzi.platzireviewscameras.dto.AutorDTO;
import com.platzi.platzireviewscameras.dto.database.Autor;
import com.platzi.platzireviewscameras.handler.mapper.AutorMapper;
import com.platzi.platzireviewscameras.models.AutorObtenerResponse;
import com.platzi.platzireviewscameras.models.AutorSaveRequest;
import com.platzi.platzireviewscameras.models.AutorSaveResponse;
import com.platzi.platzireviewscameras.repository.AutorRepository;
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
