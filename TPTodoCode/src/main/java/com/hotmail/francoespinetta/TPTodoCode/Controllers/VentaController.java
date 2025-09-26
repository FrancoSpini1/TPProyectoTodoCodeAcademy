package com.hotmail.francoespinetta.TPTodoCode.Controllers;

import com.hotmail.francoespinetta.TPTodoCode.DTOs.VentaDTO;
import com.hotmail.francoespinetta.TPTodoCode.Models.Producto;
import com.hotmail.francoespinetta.TPTodoCode.Models.Venta;
import com.hotmail.francoespinetta.TPTodoCode.Services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("ventas")
public class VentaController{

    @Autowired
    private VentaService vs;

    @PostMapping("crear")
    public void crearVenta(@RequestBody Venta v){
        vs.crearVenta(v);
    }

    @GetMapping
    public List<Venta> obtenerVentas(){
        return vs.obtenerVentas();
    }

    @GetMapping("/{id}")
    public Venta obtenerVentaPorCodigoDeVenta(@PathVariable Long id){
        return vs.obtenerVentaPorId(id);
    }

    @DeleteMapping("eliminar/{id}")
    public void eliminarVenta(@PathVariable Long id){
        vs.eliminarVenta(id);
    }

    @PutMapping("editar/{id}")
    public void editarVenta(@PathVariable Long id,@RequestBody Venta v){
        vs.editarVenta(id,v);
    }

    @GetMapping("productos/{id_venta}")
    public List<Producto> obtenerProductosDeVenta(@PathVariable Long id_venta){
        return vs.obtenerVentaPorId(id_venta).getListaProductos();
    }

    @GetMapping("/ventasDelDia/{fecha_venta}")
    public String obtenerCajaDelDiaYCantVentas(@PathVariable LocalDate fecha_venta){
        return vs.obtenerCajaDelDiaYCantVentas(fecha_venta);
    }

    @GetMapping("mayor_venta")
    @ResponseBody
    public VentaDTO obtenerVentaMasCostosa(){
        return vs.obtenerVentaMasCostosa();
    }
}
