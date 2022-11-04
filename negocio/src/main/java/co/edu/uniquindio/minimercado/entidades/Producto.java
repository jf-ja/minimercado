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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;
    @Column(unique = true)
    private String nombre;

    @ManyToOne
    private Categoria categoria;

    private double precio;
/*
    @ManyToOne
    @Nullable
    private Fecha fecha;

 */

    private String dia;

    private String mes;

    private String anio;
    private Integer unidades;
    @Nullable
    private Double descuento;

/*
    @ManyToOne
    @Nullable
    private Descuento descuento;

 */

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<PedidoProducto> pedidoProductos;

    @ToString.Exclude
    @OneToMany(mappedBy = "producto")
    private List<FacturaProducto> facturaProductos;

    @Builder
    public Producto(String nombre, Categoria categoria, double precio, String dia, String mes, String anio, Integer unidades, Double descuento) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.unidades = unidades;
        this.descuento = descuento;
    }
}
