package com.hotmail.francoespinetta.TPTodoCode.Repositories;

import com.hotmail.francoespinetta.TPTodoCode.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente,Long> {
}
