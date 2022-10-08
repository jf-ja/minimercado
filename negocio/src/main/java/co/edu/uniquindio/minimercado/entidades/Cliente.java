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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente extends Persona implements Serializable {

    public Cliente(String cedula, String nombre, String correo) {
        super(cedula, nombre, correo);
    }
    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas;

    @ElementCollection
    private List<String> telefonos;

    public Cliente(String cedula, String nombre, String correo, List<String> telefonos) {
        super(cedula, nombre, correo);
        this.telefonos = telefonos;
    }
}