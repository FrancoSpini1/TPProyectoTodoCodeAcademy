package com.hotmail.francoespinetta.TPTodoCode.IServices;

import com.hotmail.francoespinetta.TPTodoCode.Models.Producto;
import com.hotmail.francoespinetta.TPTodoCode.Repositories.ProductoReposirtory;
import com.hotmail.francoespinetta.TPTodoCode.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IProductoService implements ProductoService {

    @Autowired
    private ProductoReposirtory pr;

    @Override
    public List<Producto> obtenerProductos() {
        return pr.findAll();
    }

    @Override
    public Producto obtenerProducto(Long id) {
        return pr.findById(id).orElse(null);
    }

    @Override
    public void crearproducto(Producto p) {
        System.out.println(p.getCosto());
        pr.save(p);
    }

    @Override
    public void editarProducto(Long id,Producto pn) {
        Producto tmp = pr.findById(id).orElse(null);
        pr.delete(tmp);
        pr.save(pn);
    }

    @Override
    public void eliminarProducto(Long id) {
        pr.deleteById(id);
    }

    @Override
    public List<Producto> obtenerProductoMin5Cant() {   //esta la hice yo,funca y poco eficiente
        List<Producto> tmp= pr.findAll();
        List<Producto> mty= new ArrayList<Producto>();
        for (int i=0;i<tmp.size();i++){
            if(tmp.get(i).getCantidadDisponible() < 5){
                mty.add(tmp.get(i));
            }
        }
        return mty;
    }

    @Override
    public List<Producto> obtenerProductoMin5Cantv2() { //cahtgpt
        return pr.findByCantidadDisponibleLessThan(5);
    }
}
