package com.breitner.project.reviewscameras.dto.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Producto {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IDPRODUCTO")
    private Long idProducto;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "PRECIO")
    private Double precio;

    @JoinTable(
            name = "PRODUCTO_CARACTERISTICA",
            joinColumns = @JoinColumn(name = "IDPRODUCTO",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "IDCARACTERISTICA",nullable = false)
    )
    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    private List<Caracteristica> caracteristica;
}
