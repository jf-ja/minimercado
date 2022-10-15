package co.edu.uniquindio.minimercado.test;

import co.edu.uniquindio.minimercado.entidades.Cliente;
import co.edu.uniquindio.minimercado.repo.CategoriaRepo;
import co.edu.uniquindio.minimercado.repo.ClienteRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {
    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerClientesPorFacturaMes(){
        List<Cliente> clientes = clienteRepo.obtenerClientesPorFacturaMes("Enero");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombre());
        };
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerClientes(){
        List<Cliente> clientes = clienteRepo.findAll();
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombre());
        };
    }
}
