package com.hotmail.francoespinetta.TPTodoCode.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private String DNI;
}
