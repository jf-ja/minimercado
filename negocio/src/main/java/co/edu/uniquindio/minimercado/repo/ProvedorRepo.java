package co.edu.uniquindio.minimercado.repo;

import co.edu.uniquindio.minimercado.entidades.Provedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvedorRepo extends JpaRepository <Provedor,String> {

    @Query("select p from Provedor p where p.cedula = :cedula")
    Provedor obtenerProveedorPorCedula(String cedula);

}
