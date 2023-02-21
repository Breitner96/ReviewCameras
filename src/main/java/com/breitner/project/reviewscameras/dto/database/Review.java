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
public class Review {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IDREVIEW")
    private Long idReview;

    @Column(name = "TITULO")
    private String titulo;

    @Column(name = "CONTENIDO")
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "IDAUTOR")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "IDPRODUCTO")
    private Producto producto;

}
