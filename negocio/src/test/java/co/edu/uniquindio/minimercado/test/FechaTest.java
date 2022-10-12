package co.edu.uniquindio.minimercado.test;


import co.edu.uniquindio.minimercado.repo.DescuentoRepo;
import co.edu.uniquindio.minimercado.repo.FechaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FechaTest {
    @Autowired
    private FechaRepo fechaRepo;
}
