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
public class Descuento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    private Double porcentaje;

    @OneToMany(mappedBy = "descuento")
    private List<Producto> productos;

    public Descuento(Integer codigo, Double porcentaje) {
        this.codigo = codigo;
        this.porcentaje = porcentaje;
    }


}
