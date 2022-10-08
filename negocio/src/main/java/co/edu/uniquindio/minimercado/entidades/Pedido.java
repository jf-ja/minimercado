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
public class Pedido implements Serializable {

    @Id
    private Integer codigo;

    private Integer cantidad;

    private Integer total;

    @ManyToOne
    private Administrador administrador;

    @ManyToOne
    private Provedor provedor;

    @ManyToOne
    private Fecha fecha;

    @OneToMany(mappedBy = "pedido")
    private List<PedidoProducto> pedidoProductos;

    public Pedido(Integer codigo, Integer cantidad, Integer total, Administrador administrador, Provedor provedor, Fecha fecha) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.total = total;
        this.administrador = administrador;
        this.provedor = provedor;
        this.fecha = fecha;
    }
}
