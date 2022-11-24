package co.edu.uniquindio.minimercado.repo;

import co.edu.uniquindio.minimercado.dto.CantidadFacturaEmpleadoDTO;
import co.edu.uniquindio.minimercado.dto.CompraDTO;
import co.edu.uniquindio.minimercado.entidades.Categoria;
import co.edu.uniquindio.minimercado.entidades.Factura;
import co.edu.uniquindio.minimercado.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FacturaRepo extends JpaRepository<Factura,Integer> {

    @Query("select sum(f.total) from Factura f where f.fecha = :fecha")
    Double obtenerTotalDineroComprasPorDia(LocalDate fecha);


    //Se consultan cuanto es el promedio de las compras que ha realizado un cliente
    @Query("select new co.edu.uniquindio.minimercado.dto.CompraDTO(facturas.cliente.cedula, avg(facturas.total), facturas.cliente.nombre) From Factura facturas where facturas.cliente.cedula = :cedula")
    List<CompraDTO> obtenerPromedioComprasCliente(String cedula);

    //Se consulta la cantidad de facturas que ha registrado un empleado
    @Query("select new co.edu.uniquindio.minimercado.dto.CantidadFacturaEmpleadoDTO(facturas.empleado.cedula, count(facturas), facturas.empleado.nombre) From Factura facturas where facturas.empleado.cedula = :cedula")
    List<CantidadFacturaEmpleadoDTO> obtenerCantidadFacturasEmpleado(String cedula);

    // Se obtiene la factura con el pago mas alto
    @Query("select factura1 from Factura factura1 where factura1.total = (select max(factura.total) from Factura factura )")
    Factura obtenerMaximaFactura();

    //Se obtienen los productos de una compra dado el codigo
    @Query("select e from Factura factura join factura.productos e where factura.codigo = :codigo")
    List<Producto> obtenerProductosCompra(Integer codigo);

    //Se obtienen las facturas dada una fecha especifica
    @Query("select factura From Factura factura where factura.fecha = :fecha")
    List<Factura> obtenerFacturasFecha(LocalDate fecha);

}
