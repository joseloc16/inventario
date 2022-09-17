package com.joseloc.inventario.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "codigo_barras")
  private String codigoBarras;

  private String descripcion;

  @OneToOne//Un producto puede tener una marca
  @JoinColumn(name = "marca_id", nullable = false)
  private Marca marca;

  @ManyToOne//un producto puede pertenecer a otras categorias
  @JoinColumn(name = "categoria_id", nullable = false)
  private Categoria categoria;
}
