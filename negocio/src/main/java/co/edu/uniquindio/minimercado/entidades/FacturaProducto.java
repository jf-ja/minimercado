package co.edu.uniquindio.minimercado.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FacturaProducto implements Serializable {

    @Id
    private Integer codigo ;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    private Factura factura;

    public FacturaProducto(Integer codigo, Producto producto, Factura factura) {
        this.codigo = codigo;
        this.producto = producto;
        this.factura = factura;
    }
}
