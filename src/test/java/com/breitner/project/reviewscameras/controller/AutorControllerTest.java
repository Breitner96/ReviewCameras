package com.breitner.project.reviewscameras.controller;

import com.breitner.project.reviewscameras.dto.AutorDTO;
import com.breitner.project.reviewscameras.models.AutorObtenerResponse;
import com.breitner.project.reviewscameras.models.AutorSaveRequest;
import com.breitner.project.reviewscameras.models.AutorSaveResponse;
import com.breitner.project.reviewscameras.services.IAutorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AutorController.class)
public class AutorControllerTest {

    @MockBean
    private IAutorService iAutorService;

    static final String SAVE_AUTOR = "/api/v1/tiendabreit/save/autor";
    static final String GET_AUTOR = "/api/v1/tiendabreit/autor";

    @Autowired
    private MockMvc mockMvc;


    @Test
    void saveAutorTest () throws Exception {
        when(iAutorService.saveAutor(any())).thenReturn(getAutorSaveResponse());

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders.post(SAVE_AUTOR)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(getAutorSaveRequest()))).andExpect(
                status().isOk());
    }

    @Test
    void getAutorTest () throws Exception {
        when(iAutorService.getAllAutor()).thenReturn(getListAutorObtenerResponses());
        mockMvc.perform(MockMvcRequestBuilders.get(GET_AUTOR)).andExpect(status().isOk()).andReturn();
    }


    AutorSaveResponse getAutorSaveResponse(){
        return AutorSaveResponse.builder()
                .autorDto(AutorDTO.builder()
                        .idAutor(1L)
                        .nombre("breitner")
                        .telefono("3105258589")
                        .email("emailfalsogmail.com")
                        .pais("Colombia")
                        .build())
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

    List<AutorObtenerResponse> getListAutorObtenerResponses(){
        return List.of(AutorObtenerResponse.builder().autorDto(getAutorSaveResponse().getAutorDto()).build());
    }

}
