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
public class Producto implements Serializable {

    @Id
    private Integer codigo;

    private String nombre;

    @ManyToOne
    private Categoria categoria;

    private double precio;

    @ManyToOne
    private Fecha fecha;

    private Integer unidades;

    @ManyToOne
    private Descuento descuento;

    @OneToMany(mappedBy = "producto")
    private List<PedidoProducto> pedidoProductos;

    @OneToMany(mappedBy = "producto")
    private List<FacturaProducto> facturaProductos;

    public Producto(Integer codigo, String nombre, Categoria categoria, double precio, Fecha fecha, Integer unidades, Descuento descuento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.fecha = fecha;
        this.unidades = unidades;
        this.descuento = descuento;
    }
}
