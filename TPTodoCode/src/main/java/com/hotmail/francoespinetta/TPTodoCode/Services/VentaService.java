package com.hotmail.francoespinetta.TPTodoCode.Services;

import com.hotmail.francoespinetta.TPTodoCode.DTOs.VentaDTO;
import com.hotmail.francoespinetta.TPTodoCode.Models.Venta;
import org.springframework.web.bind.annotation.PathVariable;
import org.w3c.dom.events.EventException;

import java.time.LocalDate;
import java.util.List;

public interface VentaService {

    public void crearVenta(Venta v);
    public List<Venta> obtenerVentas();
    public Venta obtenerVentaPorId(Long id);
    public void eliminarVenta(Long id);
    public void editarVenta(Long id,Venta v);
    public String obtenerCajaDelDiaYCantVentas(LocalDate fecha_venta);
    public VentaDTO obtenerVentaMasCostosa();

}
