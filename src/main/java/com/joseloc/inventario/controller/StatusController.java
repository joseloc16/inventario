package com.joseloc.inventario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
* Esta clase se crea con la finalidad de tener la certeza (verificar) de que la api está levantada
* No es ncesario tener conexión a una BD
* */
@RestController
@RequestMapping("/status")
public class StatusController {

  public ResponseEntity<String> verificarApi() {
    return new ResponseEntity<String>("STATUS OK", HttpStatus.OK);
  }
}
