package com.platzi.platzireviewscameras.repository;

import com.platzi.platzireviewscameras.dto.database.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {
}
