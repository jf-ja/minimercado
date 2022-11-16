package co.edu.uniquindio.minimercado.repo;

import co.edu.uniquindio.minimercado.entidades.Categoria;
import co.edu.uniquindio.minimercado.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,Integer> {

    @Query ("select p from Producto p where p.categoria.nombre = :nombreCategoria")
    List<Producto> obtenerPorductosPorCategoria(String nombreCategoria);

    @Query("select f.productos from Factura f where f.cliente.cedula = :cedula")
    List<Producto> obtenerProductosCompradosPorCliente(String cedula);

    @Query("select producto from Producto producto where producto.codigo =:codigo")
    Producto obtenerProductoPorCodigo(Integer codigo);

    @Query("select producto from Producto producto where producto.nombre =:nombre")
    Producto obtenerProductoPorNombre(String nombre);
    @Query("select producto from Producto producto where producto.nombre like concat ('%',:nombre,'%')")
    List<Producto> obtenerProductosPorNombre(String nombre);
}
