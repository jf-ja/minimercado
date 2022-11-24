package co.edu.uniquindio.minimercado.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@AllArgsConstructor
@Getter
@ToString
public class CompraDTO {

    private String cedulaCliente;
    private Double promedioCompras;
    private String nombreCliente;
}
