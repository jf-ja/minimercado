package co.edu.uniquindio.minimercado.serviceTest;

import co.edu.uniquindio.minimercado.entidades.Administrador;
import co.edu.uniquindio.minimercado.entidades.Categoria;
import co.edu.uniquindio.minimercado.entidades.Producto;
import co.edu.uniquindio.minimercado.servicios.AdministradorServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class AdministradorServicioTest {

    @Autowired
    private AdministradorServicio administradorServicio;


    //------------------------------Login----------------------------------------

    @Test
    @Sql("classpath:dataset.sql")
    public void login() throws Exception {

        try {
            Administrador administrador = administradorServicio.login("admin3@gmail.com","345");
            Assertions.assertEquals("admin3@gmail.com" , administrador.getCorreo());
        }catch (Exception e){
            throw new Exception(e);
        }
    }


    //-----------------------------Productos-----------------------------------


    @Test
    @Sql("classpath:dataset.sql")
    public void crearProductoTest() throws Exception {
        try {
            Categoria categoria = new Categoria(2 , "Aseo");
            Producto producto = new Producto(5443,"Escoba" , categoria, 10000.00, null, 5, null);
            Producto productoCreado = administradorServicio.crearProducto(producto);
            Assertions.assertNotNull(productoCreado);
            System.out.println(productoCreado.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductoTest() throws Exception {
        try {
            Producto productoCreado = administradorServicio.obtenerProducto(4);
            Assertions.assertNotNull(productoCreado);
            System.out.println(productoCreado.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarProductoTest() throws Exception {
        try {
            Producto productoGuardado = administradorServicio.obtenerProducto(4);
            System.out.println(productoGuardado.getNombre());
            productoGuardado.setNombre("helados");
            Producto productoActualizado = administradorServicio.actualizarProducto(productoGuardado);
            Assertions.assertNotNull(productoActualizado);
            System.out.println(productoActualizado.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarProductoTest() throws Exception {

        try {
            administradorServicio.eliminarProducto(4);
            Producto producto = administradorServicio.obtenerProducto(4);
            Assertions.assertNull(producto);
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosTest() {
        List<Producto> productos = administradorServicio.listarProductos();
        productos.forEach(System.out::println);
    }
}
