package co.edu.uniquindio.minimercado.repo;

import co.edu.uniquindio.minimercado.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepo extends JpaRepository<Categoria,Integer> {

    @Query("select categoria From Categoria categoria")
    List<Categoria> obtenerCategorias();
}
