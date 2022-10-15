package co.edu.uniquindio.minimercado.servicios;

import co.edu.uniquindio.minimercado.entidades.Factura;

import java.util.List;

public interface EmpleadoServicio {

    public Factura crearFactura(Factura factura) throws Exception;

    public Factura actualizarFactura(Factura factura) throws Exception;

    public void eliminarFactura(Integer codigo) throws Exception;

    public List<Factura> listarFacturas();
}
