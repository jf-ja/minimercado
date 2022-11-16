package co.edu.uniquindio.minimercado.entidades;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Administrador extends Persona implements Serializable {

    @ToString.Exclude
    private String password;

    @ToString.Exclude
    @OneToMany(mappedBy = "administrador")
    private List<Pedido> pedidos;

    @ToString.Exclude
    @ElementCollection
    @Nullable
    private List<String> telefonos;

    public Administrador(String cedula, String nombre, String correo, String password) {
        super(cedula, nombre, correo);
        this.password = password;
    }
}
