package com.hotmail.francoespinetta.TPTodoCode.IServices;

import com.hotmail.francoespinetta.TPTodoCode.Models.Cliente;
import com.hotmail.francoespinetta.TPTodoCode.Repositories.ClienteRepository;
import com.hotmail.francoespinetta.TPTodoCode.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IClienteservice implements ClienteService {
    @Autowired
    private ClienteRepository cr;
    @Override
    public void crearCliente(Cliente c) {
        cr.save(c);
    }

    @Override
    public Cliente obtenerCliente(Long id) {
        return cr.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return cr.findAll();
    }

    @Override
    public void eliminarCliente(Long id) {
        cr.deleteById(id);
    }

    @Override
    public void editarCliente(Long id, Cliente cn) {
        Cliente tmp=cr.findById(id).orElse(null);
        cr.delete(tmp);
        cr.save(cn);
    }
}
