package com.platzi.platzireviewscameras.dto.database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Autor {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "IDAUTOR")
    private Long idAutor;
    @Column
    private String nombre;
    @Column(length=10, unique=true)
    private String telefono;
    @Column
    private String email;
    @Column
    private String pais;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Autor autor = (Autor) o;
        return idAutor != null && Objects.equals(idAutor, autor.idAutor);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
