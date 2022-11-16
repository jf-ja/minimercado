package co.edu.uniquindio.minimercado.repo;

import co.edu.uniquindio.minimercado.entidades.Categoria;
import co.edu.uniquindio.minimercado.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface FacturaRepo extends JpaRepository<Factura,Integer> {

    @Query("select sum(f.total) from Factura f where f.fecha = :fecha")
    Double obtenerTotalDineroComprasPorDia(LocalDate fecha);
}
