package com.breitner.project.reviewscameras.dto.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IDCARACTERISTICA")
    private Long idCaracteristica;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DETALLES")
    private String detalles;

}
