package com.hotmail.francoespinetta.TPTodoCode.Repositories;

import com.hotmail.francoespinetta.TPTodoCode.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoReposirtory extends JpaRepository<Producto,Long> {
    List<Producto> findByCantidadDisponibleLessThan(int cantidad); //chatgpt me tiro esta
}
