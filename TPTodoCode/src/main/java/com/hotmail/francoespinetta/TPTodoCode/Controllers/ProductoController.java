package com.hotmail.francoespinetta.TPTodoCode.Controllers;

import com.hotmail.francoespinetta.TPTodoCode.Models.Producto;
import com.hotmail.francoespinetta.TPTodoCode.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productos")
public class ProductoController {

    @Autowired
    private ProductoService pc;

    @PostMapping("crear")
    public void crearProducto(@RequestBody Producto p){
        pc.crearproducto(p);
    }

    @GetMapping
    public List<Producto> obtenerProductos(){
        return pc.obtenerProductos();
    }

    @GetMapping("{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id){
        return pc.obtenerProducto(id);
    }

    @DeleteMapping("eliminar/{id}")
    public void eliminarProductoPorId(@PathVariable Long id){
        pc.eliminarProducto(id);
    }

    @PutMapping("editar/{id}")
    public void editarProducto(@PathVariable Long id,@RequestBody Producto pn){
        pc.editarProducto(id,pn);
    }

    @GetMapping("falta_stock")
    public List<Producto> obtenerProductoMin5Cant(){
        return pc.obtenerProductoMin5Cant();
    }

}
