package co.edu.uniquindio.minimercado.entidades;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
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

    private LocalDate fechaVencimiento;

    private Integer unidades;
    @Nullable
    private Double descuento;

    @ToString.Exclude
    @ManyToMany(mappedBy = "productos")
    private List<Factura> facturas;

    @ToString.Exclude
    @ManyToMany(mappedBy = "productos")
    private List<Pedido> pedidos;

    @Builder
    public Producto(String nombre, Categoria categoria, double precio, LocalDate fechaVencimiento, Integer unidades, Double descuento) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.fechaVencimiento=fechaVencimiento;
        this.unidades = unidades;
        this.descuento = descuento;
    }
}
