package com.platzi.platzireviewscameras.services;

import com.platzi.platzireviewscameras.dto.AutorDTO;
import com.platzi.platzireviewscameras.dto.ProductoDTO;
import com.platzi.platzireviewscameras.handler.mapper.ProductoMapper;
import com.platzi.platzireviewscameras.models.AutorObtenerResponse;
import com.platzi.platzireviewscameras.models.ProductoObtenerResponse;
import com.platzi.platzireviewscameras.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    ProductoMapper productoMapper;

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public List<ProductoObtenerResponse> getAllProducts() {
        List<ProductoDTO> productoDto=productoMapper.EntitytoDTOList( productoRepository.findAll());
        List<ProductoObtenerResponse> productoObtenerResponse=new ArrayList<>();
        for (int i = 0; i < productoDto.size(); i++) {
            productoObtenerResponse.add(new ProductoObtenerResponse());
        }
        final int[] i = {0};
        productoObtenerResponse.forEach(x->{
            x.setProductoDto(productoDto.get(i[0]));
            i[0]++;
        });
        log.info("autorResponse, {}: ",productoObtenerResponse);
        return productoObtenerResponse;
    }
}
