package co.edu.uniquindio.minimercado.entidades;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
public class Provedor extends Persona implements Serializable {

    @ToString.Exclude
    @OneToMany(mappedBy = "provedor")
    private List<Pedido> pedidos;

    @ToString.Exclude
    @ElementCollection
    @Nullable
    private List<String> telefonos;

    public Provedor(String cedula, String nombre, String correo, List<String> telefonos) {
        super(cedula, nombre, correo);
        this.telefonos = telefonos;
    }
}
