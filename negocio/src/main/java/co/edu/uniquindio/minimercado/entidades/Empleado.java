package co.edu.uniquindio.minimercado.entidades;


import lombok.*;

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
    @OneToMany(mappedBy = "empleado")
    private List<Factura> facturas;

    @ToString.Exclude
    @ElementCollection
    private List<String> telefonos;

    public Empleado(String cedula, String nombre, String correo, List<String> telefonos) {
        super(cedula, nombre, correo);
        this.telefonos = telefonos;
    }


}
