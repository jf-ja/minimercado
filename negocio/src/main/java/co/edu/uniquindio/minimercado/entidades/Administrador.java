package co.edu.uniquindio.minimercado.entidades;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador extends Persona{

    @ToString.Exclude
    private String password;

    @OneToMany(mappedBy = "administrador")
    private List<Pedido> pedidos;

    @ElementCollection
    private List<String> telefonos;

    public Administrador(String cedula, String nombre, String correo, String password, List<String> telefonos) {
        super(cedula, nombre, correo);
        this.password = password;
        this.telefonos = telefonos;
    }
}
