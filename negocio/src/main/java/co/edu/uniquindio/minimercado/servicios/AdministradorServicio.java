package co.edu.uniquindio.minimercado.servicios;

import co.edu.uniquindio.minimercado.entidades.Administrador;
import co.edu.uniquindio.minimercado.entidades.Categoria;
import co.edu.uniquindio.minimercado.entidades.Producto;

import java.util.List;

public interface AdministradorServicio {


    public Administrador login (String correo, String contrasenia)throws Exception;
    public Producto crearProducto(Producto producto) throws Exception;

    public Producto obtenerProducto(Integer codigo) throws Exception;

    public List<Producto> obtenerProductosPorNombre(String nombre) throws Exception;

    public Producto actualizarProducto(Producto producto) throws Exception;

    public void eliminarProducto(Integer codigo) throws Exception;

    public List<Producto> listarProductos();

    public List<Categoria> listarCategorias();

    public Categoria obtenerCategoria(Integer codigo);

}
