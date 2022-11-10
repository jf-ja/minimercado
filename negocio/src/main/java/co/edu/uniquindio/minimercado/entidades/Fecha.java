package co.edu.uniquindio.minimercado.entidades;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Fecha implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    private String dia;

    private String mes;

    private String anio;
/*
    @ToString.Exclude
    @OneToMany(mappedBy = "fecha")
    private List<Producto> productos;
*/

    @ToString.Exclude
    @OneToMany(mappedBy = "fecha")
    private List<Factura> facturas;



    @ToString.Exclude
    @OneToMany(mappedBy = "fecha")
    private List<Pedido> pedidos;

    public Fecha(Integer codigo, String dia, String mes, String anio) {
        this.codigo = codigo;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }



}
