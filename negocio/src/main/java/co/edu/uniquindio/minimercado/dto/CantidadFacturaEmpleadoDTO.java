package co.edu.uniquindio.minimercado.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class CantidadFacturaEmpleadoDTO {

    private String cedulaEmpleado;
    private Long cantidadFacturas;
    private String nombreEmpleado;
}
