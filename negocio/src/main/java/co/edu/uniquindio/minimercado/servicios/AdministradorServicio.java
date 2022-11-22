package co.edu.uniquindio.minimercado.servicios;

import co.edu.uniquindio.minimercado.entidades.*;

import java.util.List;
import java.util.Optional;

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
    public Pedido realizarPedido(Pedido pedido) throws Exception;
    public Administrador obtenerAdministrador(String cedula) throws Exception;
    public Provedor obtenerProvedor(String cedula) throws Exception;

}
