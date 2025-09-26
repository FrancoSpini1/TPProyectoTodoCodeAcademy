package com.hotmail.francoespinetta.TPTodoCode.IServices;

import com.hotmail.francoespinetta.TPTodoCode.DTOs.VentaDTO;
import com.hotmail.francoespinetta.TPTodoCode.Models.Producto;
import com.hotmail.francoespinetta.TPTodoCode.Models.Venta;
import com.hotmail.francoespinetta.TPTodoCode.Repositories.ProductoReposirtory;
import com.hotmail.francoespinetta.TPTodoCode.Repositories.VentaRepository;
import com.hotmail.francoespinetta.TPTodoCode.Services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class IVentaService implements VentaService {

    @Autowired
    private VentaRepository vr;
    @Autowired
    private ProductoReposirtory pr;

    @Override
    public void crearVenta(Venta v) {
        v.setFechaVenta(LocalDate.now());
        List<Producto> lp = new ArrayList<>();
        double total=0;
        long idPr=0;
        for(int i=0;i<v.getListaProductos().size();i++){//si el postman tiene 3 prod=> i == 0,1,2
            idPr = v.getListaProductos().get(i).getCodigoProducto();// aca en teoria agarro la id de los productos
            //que pase por el postman
            lp.add(pr.findById(idPr).orElse(null));//aca agarro y meto en la lista lp los productos con
//            la id del idPr
            total+=lp.get(i).getCosto();//voy sumando los cosos
        }
        v.setTotal(total);
        vr.save(v);
    }

    @Override
    public List<Venta> obtenerVentas() {
        return vr.findAll();
    }

    @Override
    public Venta obtenerVentaPorId(Long id) {
        return vr.findById(id).orElse(null);
    }

    @Override
    public void eliminarVenta(Long id) {
        vr.deleteById(id);
    }

    @Override
    public void editarVenta(Long id, Venta v) {
        Venta tmp = vr.findById(id).orElse(null);
        vr.delete(tmp);
        vr.save(v);
    }

    @Override
    public String obtenerCajaDelDiaYCantVentas(LocalDate fecha_venta) {
        List<Venta> tmp = vr.findByFechaVenta(fecha_venta);
        double montoTotal=0.0;
        int cantVentas;
        for (cantVentas=0;cantVentas<tmp.size();cantVentas++){
            montoTotal += tmp.get(cantVentas).getTotal();
        }
        return "cantidad de ventas de: "+fecha_venta+">>"+ tmp.size() +" suma un total " +
                "de: " + montoTotal;
    }

    public VentaDTO obtenerVentaMasCostosa(){

        Venta tmp = vr.findTopByOrderByTotalDesc();
        VentaDTO vDTO=new VentaDTO();
        vDTO.setIdCodigoVenta(tmp.getCodigoVenta());
        vDTO.setMonto(tmp.getTotal());
        vDTO.setCantidadProductos(tmp.getListaProductos().size());
        vDTO.setNombreCliente(tmp.getUnCliente().getNombre());
        vDTO.setApellidoCliente(tmp.getUnCliente().getApellido());
        return vDTO;
    }

}
