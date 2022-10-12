package co.edu.uniquindio.minimercado.repo;

import co.edu.uniquindio.minimercado.entidades.Categoria;
import co.edu.uniquindio.minimercado.entidades.Fecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FechaRepo extends JpaRepository<Fecha,Integer> {
}
