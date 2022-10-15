package co.edu.uniquindio.minimercado.servicios;

import co.edu.uniquindio.minimercado.entidades.Administrador;
import co.edu.uniquindio.minimercado.entidades.Producto;

import java.util.List;

public interface AdministradorServicio {


    public Administrador login (String correo, String contrasenia)throws Exception;
    public Producto crearProducto(Producto producto) throws Exception;

    public Producto actualizarProducto(Producto producto) throws Exception;

    public void eliminarProducto(Integer codigo) throws Exception;

    public List<Producto> listarProductos();

}
