package co.edu.uniquindio.minimercado.entidades;


import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Empleado extends Persona implements Serializable {

    @ToString.Exclude
    private String password;

    @ToString.Exclude
    @OneToMany(mappedBy = "empleado")
    private List<Factura> facturas;

    @ToString.Exclude
    @ElementCollection
    @Nullable
    private List<String> telefonos;

    public Empleado(String cedula, String nombre, String correo, String password) {
        super(cedula, nombre, correo);
        this.password = password;
    }
}
