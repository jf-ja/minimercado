package co.edu.uniquindio.minimercado.repo;

import co.edu.uniquindio.minimercado.entidades.Administrador;
import co.edu.uniquindio.minimercado.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador,String> {

    @Query("select a from Administrador a where a.correo = :correo and a.password = :contrasenia")
    Administrador compraboarAuntenticacion(String correo, String contrasenia);

    @Query("select a from Administrador a where a.cedula=: cedula")
    Administrador obtenerAdministrador(String cedula);
}
