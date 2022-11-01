package co.edu.uniquindio.minimercado.serviceTest;

import co.edu.uniquindio.minimercado.entidades.Cliente;
import co.edu.uniquindio.minimercado.servicios.EmpleadoServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;


@SpringBootTest
@Transactional
public class EmpleadoServicioTest {


    @Autowired
    private EmpleadoServicio empleadoServicio;


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
