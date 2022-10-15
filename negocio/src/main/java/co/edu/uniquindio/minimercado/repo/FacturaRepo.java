package co.edu.uniquindio.minimercado.repo;

import co.edu.uniquindio.minimercado.entidades.Categoria;
import co.edu.uniquindio.minimercado.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepo extends JpaRepository<Factura,Integer> {

    @Query("select sum(f.total) from Factura f where f.fecha.dia = :dia and f.fecha.mes =:mes and f.fecha.anio = :anio")
    Double obtenerTotalDineroComprasPorDia(String dia, String mes, String anio);
}
