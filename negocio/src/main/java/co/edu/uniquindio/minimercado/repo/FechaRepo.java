package co.edu.uniquindio.minimercado.repo;

import co.edu.uniquindio.minimercado.entidades.Categoria;
import co.edu.uniquindio.minimercado.entidades.Fecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FechaRepo extends JpaRepository<Fecha,Integer> {

    @Query("select fecha From Fecha fecha where fecha.codigo = :codigo")
    Optional<Fecha> obtenerFechaPorCodigo(Integer codigo);
}
