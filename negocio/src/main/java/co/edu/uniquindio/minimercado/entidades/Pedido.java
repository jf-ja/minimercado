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

    private Integer total;

    @ManyToOne
    private Administrador administrador;

    @ManyToOne
    private Provedor provedor;

    private LocalDate fecha;

    @ToString.Exclude
    @ManyToMany
    private List<Producto> productos;

    public Pedido(Integer codigo, Integer cantidad, Integer total, Administrador administrador, Provedor provedor, LocalDate fecha) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.total = total;
        this.administrador = administrador;
        this.provedor = provedor;
        this.fecha = fecha;
    }
}
