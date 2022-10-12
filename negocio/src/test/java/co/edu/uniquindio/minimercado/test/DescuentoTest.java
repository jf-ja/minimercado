package co.edu.uniquindio.minimercado.test;


import co.edu.uniquindio.minimercado.repo.CategoriaRepo;
import co.edu.uniquindio.minimercado.repo.DescuentoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DescuentoTest {
    @Autowired
    private DescuentoRepo descuentoRepo;
}
