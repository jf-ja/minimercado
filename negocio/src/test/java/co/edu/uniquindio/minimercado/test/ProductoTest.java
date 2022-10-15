package co.edu.uniquindio.minimercado.test;


import co.edu.uniquindio.minimercado.entidades.Producto;
import co.edu.uniquindio.minimercado.repo.DescuentoRepo;
import co.edu.uniquindio.minimercado.repo.ProductoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {
    @Autowired
    private ProductoRepo productoRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductosPorCategoria(){

        List<Producto> productos = productoRepo.obtenerPorductosPorCategoria("Aseo");
        for (Producto producto: productos) {
            System.out.println(producto.getNombre());
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerProductosPorCliente(){

        List<Producto> productos = productoRepo.obtenerProductosCompradosPorCliente("2222");
        for (Producto producto: productos) {
            System.out.println(producto.getNombre());
        }
    }

}
