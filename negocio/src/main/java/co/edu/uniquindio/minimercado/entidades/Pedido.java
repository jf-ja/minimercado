package co.edu.uniquindio.minimercado.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Integer codigo;

    private Integer cantidad;

    private Double total;

    @ManyToOne
    private Administrador administrador;

    @ManyToOne
    private Provedor provedor;

    private LocalDate fecha;

    @ToString.Exclude
    @ManyToMany
    private List<Producto> productos;

    @Builder
    public Pedido( Integer cantidad, Double total, Administrador administrador, Provedor provedor, LocalDate fecha) {
        this.cantidad = cantidad;
        this.total = total;
        this.administrador = administrador;
        this.provedor = provedor;
        this.fecha = fecha;
    }
}
