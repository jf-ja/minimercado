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
public class Provedor extends Persona implements Serializable {

    @OneToMany(mappedBy = "provedor")
    private List<Pedido> pedidos;

    @ElementCollection
    private List<String> telefonos;

    public Provedor(String cedula, String nombre, String correo, List<String> telefonos) {
        super(cedula, nombre, correo);
        this.telefonos = telefonos;
    }
}
