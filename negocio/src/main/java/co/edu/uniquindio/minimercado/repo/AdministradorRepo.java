package co.edu.uniquindio.minimercado.repo;

import co.edu.uniquindio.minimercado.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador,String> {
}
