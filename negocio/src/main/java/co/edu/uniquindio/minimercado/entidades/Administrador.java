package co.edu.uniquindio.minimercado.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador extends Persona{

    public Administrador(String cedula, String nombre, String correo) {
        super(cedula, nombre, correo);
    }
}
