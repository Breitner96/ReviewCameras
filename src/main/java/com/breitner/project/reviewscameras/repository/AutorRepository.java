package com.breitner.project.reviewscameras.repository;

import com.breitner.project.reviewscameras.dto.database.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {
}
