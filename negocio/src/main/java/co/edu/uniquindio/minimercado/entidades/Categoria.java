package co.edu.uniquindio.minimercado.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private String nombre;


    @ToString.Exclude
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    public Categoria(String nombre) {
        this.nombre = nombre;
    }
}
