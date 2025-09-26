package com.hotmail.francoespinetta.TPTodoCode.Controllers;

import com.hotmail.francoespinetta.TPTodoCode.Models.Cliente;
import com.hotmail.francoespinetta.TPTodoCode.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ClienteService cs;

    @PostMapping("crear")
    public void crearCliente(@RequestBody Cliente c){
        cs.crearCliente(c);
    }

    @GetMapping
    public List<Cliente> obtenerClientes(){
        return cs.obtenerClientes();
    }

    @GetMapping("{id}")
    public Cliente obtenerCliente(@PathVariable Long id){
        return cs.obtenerCliente(id);
    }

    @DeleteMapping("eliminar/{id}")
    public void eliminarClientePorId(@PathVariable Long id){
        cs.eliminarCliente(id);
    }

    @PutMapping("editar/{id}")
    public void editarCliente(@PathVariable Long id, @RequestBody Cliente cn){
        cs.editarCliente(id,cn);
    }
}
