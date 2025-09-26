package com.hotmail.francoespinetta.TPTodoCode.DTOs;

import lombok.Data;

@Data
public class VentaDTO {
    private String nombreCliente;
    private String apellidoCliente;
    private double monto;
    private int cantidadProductos;
    private long idCodigoVenta;
}
