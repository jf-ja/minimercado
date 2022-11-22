package co.edu.uniquindio.minimercado.serviceTest;

import co.edu.uniquindio.minimercado.entidades.*;
import co.edu.uniquindio.minimercado.repo.AdministradorRepo;
import co.edu.uniquindio.minimercado.repo.ProvedorRepo;
import co.edu.uniquindio.minimercado.servicios.AdministradorServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class AdministradorServicioTest {

    @Autowired
    private AdministradorServicio administradorServicio;
    private AdministradorRepo administradorRepo;
    private ProvedorRepo provedorRepo;



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
            LocalDate fecha = LocalDate.now();
            Categoria categoria = administradorServicio.obtenerCategoria(1);
            Producto producto = new Producto("Escoba" , categoria, 10000.00, fecha, 5, null);
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
    public void obtenerCategoriaTest() throws Exception {
        try {
            Categoria categoria = administradorServicio.obtenerCategoria(2);
            Assertions.assertNotNull(categoria);
            System.out.println(categoria.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarProductosTest() {
        List<Producto> productos = administradorServicio.listarProductos();
        productos.forEach(System.out::println);
    }

    //-------------------------categorias---------------------

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCategoriasTest() {
        List<Categoria> categorias = administradorServicio.listarCategorias();
        categorias.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void realizarPedidoTest() throws Exception{

        LocalDate fecha = LocalDate.now();
        Optional<Administrador> admin = administradorRepo.findById("111");
        Provedor provedor = provedorRepo.findById("11").orElse(null);
        Pedido pedido = Pedido.builder().cantidad(8).total(3200).administrador(admin).provedor(provedor).fecha(fecha).build();

        try {
            Pedido nuevo = administradorServicio.realizarPedido(pedido);
            Assertions.assertNotNull(nuevo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
