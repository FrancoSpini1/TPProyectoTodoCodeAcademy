package com.hotmail.francoespinetta.TPTodoCode.Services;

import com.hotmail.francoespinetta.TPTodoCode.Models.Cliente;

import java.util.List;

public interface ClienteService {
    public void crearCliente(Cliente c);
    public Cliente obtenerCliente(Long id);
    public List<Cliente> obtenerClientes();
    public void eliminarCliente(Long id);
    public void editarCliente(Long id,Cliente cn);
}
