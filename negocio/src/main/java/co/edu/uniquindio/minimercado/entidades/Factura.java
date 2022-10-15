package co.edu.uniquindio.minimercado.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    private Integer codigo;

    private Double total;

    @ManyToOne
    private Empleado empleado;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Fecha fecha;

    @ToString.Exclude
    @OneToMany(mappedBy = "factura")
    private List<FacturaProducto> facturaProductos;

    public Factura(Integer codigo, Double total, Empleado empleado, Cliente cliente, Fecha fecha) {
        this.codigo = codigo;
        this.total = total;
        this.empleado = empleado;
        this.cliente = cliente;
        this.fecha = fecha;
    }


}
