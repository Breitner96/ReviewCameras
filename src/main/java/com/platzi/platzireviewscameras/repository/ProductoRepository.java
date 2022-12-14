package com.platzi.platzireviewscameras.repository;

import com.platzi.platzireviewscameras.dto.database.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
