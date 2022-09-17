package com.joseloc.inventario.service.impl;

import com.joseloc.inventario.entity.Marca;
import com.joseloc.inventario.repository.IMarcaRepository;
import com.joseloc.inventario.service.IMarcaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements IMarcaService {

  private final IMarcaRepository marcaRepository;

  @Override
  public void saveOrUpdate(Marca marca) {
    marcaRepository.save(marca);
  }

  @Override
  public Marca getById(Integer id) {
    return marcaRepository.getReferenceById(id);
  }

  @Override
  public List<Marca> listAll() {
    return marcaRepository.findAll();
  }

  @Override
  public void deleteById(Integer id) {
    marcaRepository.deleteById(id);
  }
}
