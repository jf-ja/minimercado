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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private Double total;

    @ManyToOne
    private Empleado empleado;

    @ManyToOne
    private Cliente cliente;

    @Nullable
    @ManyToOne
    private Fecha fecha;

    @ToString.Exclude
    @ManyToMany(mappedBy = "facturas")
    private List<Producto> productos;

    @Builder
    public Factura(Double total, Empleado empleado, Cliente cliente, Fecha fecha) {
        this.total = total;
        this.empleado = empleado;
        this.cliente = cliente;
        this.fecha = fecha;
    }


}
