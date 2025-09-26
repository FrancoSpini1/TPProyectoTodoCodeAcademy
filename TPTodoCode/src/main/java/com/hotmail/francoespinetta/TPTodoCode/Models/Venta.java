package com.hotmail.francoespinetta.TPTodoCode.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="Ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoVenta;
    private LocalDate fechaVenta;
    private Double total;
    @OneToMany
    private List<Producto> listaProductos;  //(1 ,n)
    @OneToOne
    @JoinColumn(name="idCliente",referencedColumnName = "id")
    private Cliente unCliente;  //(1,1)

}
