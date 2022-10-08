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
public class PedidoProducto implements Serializable {

    @Id
    private Integer codigo;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Producto producto;

    public PedidoProducto(Integer codigo, Pedido pedido, Producto producto) {
        this.codigo = codigo;
        this.pedido = pedido;
        this.producto = producto;
    }
}
