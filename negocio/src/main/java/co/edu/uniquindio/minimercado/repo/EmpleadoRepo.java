package co.edu.uniquindio.minimercado.repo;

import co.edu.uniquindio.minimercado.entidades.Administrador;
import co.edu.uniquindio.minimercado.entidades.Categoria;
import co.edu.uniquindio.minimercado.entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepo extends JpaRepository<Empleado,String> {

    @Query("select e from Empleado e where e.correo = :correo and e.password = :contrasenia")
    Empleado compraboarAuntenticacion(String correo, String contrasenia);
}
