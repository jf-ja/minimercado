package co.edu.uniquindio.minimercado.servicios;

import co.edu.uniquindio.minimercado.entidades.Cliente;
import co.edu.uniquindio.minimercado.entidades.Factura;

import java.util.List;

public interface EmpleadoServicio {


    //-------------------------------- CRUD DE FACTURA ----------------------------

    public Factura crearFactura(Factura factura) throws Exception;

    public Factura obtenerFacturaPorCodigo(Integer codigo) throws Exception;

    public Factura actualizarFactura(Factura factura) throws Exception;

    public void eliminarFactura(Integer codigo) throws Exception;

    public List<Factura> listarFacturas();


    //-------------------------------- CRUD DE CLIENTE ----------------------------

    public Cliente registrarCliente(Cliente cliente) throws Exception;

    public Cliente obtenerClientePorCedula(String cedula) throws Exception;

    public Cliente actualizarCliente(Cliente cliente) throws Exception;

    public void eliminarCliente(String codigoCliente) throws Exception;

    public List<Cliente> listarClientes();


}
