package co.edu.uniquindio.minimercado.repo;

import co.edu.uniquindio.minimercado.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,String> {

    @Query("select f.cliente from Factura f where f.fecha = :fecha")
    List<Cliente> obtenerClientesPorFacturaMes(String fecha);

    Optional<Cliente> findByCorreo(String correo);
    List<Cliente> findAll();

}
