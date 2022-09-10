package com.joseloc.inventario.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "codigo_barras")
  private String codigoBarras;

  @Column(name = "descripcion")
  private String descripcion;

  @Column(name = "marca")
  private Marca marca;

  @Column(name = "categoria")
  private Categoria categoria;
}
