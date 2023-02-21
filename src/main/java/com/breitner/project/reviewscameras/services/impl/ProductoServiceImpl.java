package com.breitner.project.reviewscameras.services.impl;

import com.breitner.project.reviewscameras.dto.ProductoDTO;
import com.breitner.project.reviewscameras.handler.mapper.ProductoMapper;
import com.breitner.project.reviewscameras.models.ProductoObtenerResponse;
import com.breitner.project.reviewscameras.repository.ProductoRepository;
import com.breitner.project.reviewscameras.services.IProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductoServiceImpl implements IProductoService {

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
