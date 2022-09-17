package com.joseloc.inventario.repository;

import com.joseloc.inventario.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMarcaRepository extends JpaRepository<Marca, Integer> {

}
