package co.edu.uniquindio.minimercado.serviceTest;

import co.edu.uniquindio.minimercado.entidades.Cliente;
import co.edu.uniquindio.minimercado.entidades.Empleado;
import co.edu.uniquindio.minimercado.entidades.Factura;
import co.edu.uniquindio.minimercado.entidades.Fecha;
import co.edu.uniquindio.minimercado.repo.ClienteRepo;
import co.edu.uniquindio.minimercado.repo.EmpleadoRepo;
import co.edu.uniquindio.minimercado.repo.FechaRepo;
import co.edu.uniquindio.minimercado.servicios.EmpleadoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@Transactional
public class EmpleadoServicioTest {


    @Autowired
    private EmpleadoServicio empleadoServicio;

    @Autowired
    private EmpleadoRepo empleadoRepo;
    @Autowired
    private ClienteRepo clienteRepo;

    @Autowired
    private FechaRepo fechaRepo;

    //-------------------------------------FACTURA----------------------------------------------

    @Test
    @Sql("classpath:dataset.sql")
    public void crearFacturaTest() throws Exception {

        Fecha fecha = fechaRepo.obtenerFechaPorCodigo(2).orElse(null);
        Empleado empleado = empleadoRepo.findById("0111").orElse(null);
        Cliente cliente = clienteRepo.findById("1111").orElse(null);
        Factura factura = Factura.builder().codigo(5).total(12400.00).fecha(fecha).empleado(empleado).cliente(cliente).build();

        try {
            Factura nuevo = empleadoServicio.crearFactura(factura);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarFacturaTest() throws Exception {

        try {
            Factura factura = empleadoServicio.obtenerFacturaPorCodigo(2);
            System.out.println(factura.getTotal());
            factura.setTotal(45000.00);
            Factura nuevoFactura = empleadoServicio.actualizarFactura(factura);
            Assertions.assertEquals(45000.00, nuevoFactura.getTotal());
            System.out.println(nuevoFactura.getTotal());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarFacturaTest() throws Exception {
        try {
            empleadoServicio.eliminarFactura(2);
            Factura factura = empleadoServicio.obtenerFacturaPorCodigo(2);
            Assertions.assertNull(factura);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarFacturasTest() {
        List<Factura> listaFacturas = empleadoServicio.listarFacturas();
        listaFacturas.forEach(System.out::println);
    }



    //-------------------------------------CLIENTE----------------------------------------------
    @Test
    @Sql("classpath:dataset.sql")
    public void registrarClienteTest() {
        Cliente cliente = Cliente.builder().cedula("4221").nombre("tony").correo("tony@gmail.com").telefonos(null).build();
        try {
            Cliente nuevo = empleadoServicio.registrarCliente(cliente);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarClienteTest() {

        try {
            Cliente cliente = empleadoServicio.obtenerClientePorCedula("2222");
            cliente.setNombre("Nuevo nombre");
            Cliente nuevoCliente = empleadoServicio.actualizarCliente(cliente);
            Assertions.assertEquals("Nuevo nombre", nuevoCliente.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarClienteTest() {

        try {
            empleadoServicio.eliminarCliente("2222");
            Cliente cliente = empleadoServicio.obtenerClientePorCedula("2222");
            Assertions.assertNull(cliente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listarClienteTest() {
        List<Cliente> listaClientes = empleadoServicio.listarClientes();
        listaClientes.forEach(System.out::println);
    }




}
