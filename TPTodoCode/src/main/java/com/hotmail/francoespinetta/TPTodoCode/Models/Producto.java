package com.hotmail.francoespinetta.TPTodoCode.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoProducto;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidadDisponible;

}

