package co.edu.uniquindio.minimercado.repo;

import co.edu.uniquindio.minimercado.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente,String> {
}
