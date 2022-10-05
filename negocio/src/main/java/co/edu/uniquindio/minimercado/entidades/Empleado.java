package co.edu.uniquindio.minimercado.entidades;


import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empleado extends Persona implements Serializable {

    public Empleado(String cedula, String nombre, String correo) {
        super(cedula, nombre, correo);
    }
}
