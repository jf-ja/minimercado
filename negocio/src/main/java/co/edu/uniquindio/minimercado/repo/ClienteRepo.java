package co.edu.uniquindio.minimercado.repo;

import co.edu.uniquindio.minimercado.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,String> {

    @Query("select f.cliente from Factura f where f.fecha.mes = :mes")
    List<Cliente> obtenerClientesPorFacturaMes(String mes);

    List<Cliente> findAll();

}
