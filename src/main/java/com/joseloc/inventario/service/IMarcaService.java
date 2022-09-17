package com.joseloc.inventario.service;

import com.joseloc.inventario.entity.Marca;

import java.util.List;

public interface IMarcaService {
  void saveOrUpdate(Marca marca);

  Marca getById(Integer id);

  List<Marca> listAll();

  void deleteById(Integer id);
}
