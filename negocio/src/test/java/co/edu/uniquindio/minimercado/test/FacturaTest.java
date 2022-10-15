package co.edu.uniquindio.minimercado.test;

import co.edu.uniquindio.minimercado.entidades.Producto;
import co.edu.uniquindio.minimercado.repo.FacturaRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FacturaTest {
    @Autowired
    private FacturaRepo facturaRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerTotalDineroComprasPorDia(){
        Double total = facturaRepo.obtenerTotalDineroComprasPorDia("2", "Febrero", "2021");
        System.out.println(total);
    }
}
