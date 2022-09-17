package com.joseloc.inventario.controller.mantenimientos;

import com.joseloc.inventario.entity.Marca;
import com.joseloc.inventario.model.ResponseApi;
import com.joseloc.inventario.service.IMarcaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/marca")
@RequiredArgsConstructor
public class MarcaController {

  private final IMarcaService marcaService;

  @GetMapping
  public ResponseEntity<List<Marca>> listMarca() {
    log.info("Listar todas las marcas");
    List<Marca> marcas = marcaService.listAll();
    return new ResponseEntity<>(marcas, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ResponseApi> saveMarca(@RequestBody Marca marca) {
    log.info("Guardar nueva marca");
    try {
      marcaService.saveOrUpdate(marca);
    } catch (Exception e) {
      MarcaController.log.error("Error al guardar");
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(new ResponseApi("OK"), HttpStatus.OK);
  }

  /*
  @GetMapping("/{id}")
  public ResponseEntity<Marca> getMarca(@PathVariable("id") Integer id) {
    log.info("Obtener marca por Id");
    Optional<Marca> marca = Optional.of(marcaService.getById(id));
    return marca.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @PutMapping
  public ResponseEntity<Marca> updateMarca(@RequestBody Marca marca) {

    Optional<Marca> optionalMarca = Optional.ofNullable(marcaService.getById(marca.getId()));

    if(optionalMarca.isPresent()) {
      Marca marca1 = optionalMarca.get();
      marca1.setDescripcion(marca.getDescripcion());
      return ResponseEntity.status(HttpStatus.CREATED).body(marca1);
    }
    return ResponseEntity.notFound().build();
  }
  */

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteMarca(@PathVariable("id") Integer id) {
    log.info("Eliminar marca por Id");
    try {
      marcaService.deleteById(id);
      return ResponseEntity.noContent().build();
    } catch (EmptyResultDataAccessException e) {
      log.error("fallo al encontrar marca");
      return ResponseEntity.notFound().build();
    }
  }

}
