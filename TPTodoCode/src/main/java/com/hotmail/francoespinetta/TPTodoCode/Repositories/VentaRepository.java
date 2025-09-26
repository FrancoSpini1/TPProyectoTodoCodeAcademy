package com.hotmail.francoespinetta.TPTodoCode.Repositories;

import com.hotmail.francoespinetta.TPTodoCode.Models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Long> {
    List<Venta> findByFechaVenta(LocalDate fecha);
    Venta findTopByOrderByTotalDesc();
}
