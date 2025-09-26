package com.hotmail.francoespinetta.TPTodoCode.Services;


import com.hotmail.francoespinetta.TPTodoCode.Models.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> obtenerProductos();
    public Producto obtenerProducto(Long id);
    public void crearproducto(Producto p);
    public void editarProducto(Long id,Producto pn);
    public void eliminarProducto(Long id);
    public List<Producto> obtenerProductoMin5Cant();
    public List<Producto> obtenerProductoMin5Cantv2(); //cahtgpt
}
