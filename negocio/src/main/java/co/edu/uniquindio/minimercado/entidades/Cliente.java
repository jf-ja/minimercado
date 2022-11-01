package co.edu.uniquindio.minimercado.entidades;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
public class Cliente extends Persona implements Serializable {

    public Cliente(String cedula, String nombre, String correo) {
        super(cedula, nombre, correo);
    }

    @ToString.Exclude
    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas;

    @ToString.Exclude
    @ElementCollection
    @Nullable
    private List<String> telefonos;
    @Builder
    public Cliente(String cedula, String nombre, String correo, List<String> telefonos) {
        super(cedula, nombre, correo);
        this.telefonos = telefonos;
    }
}
