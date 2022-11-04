package co.edu.uniquindio.minimercado.bean;

import co.edu.uniquindio.minimercado.entidades.Cliente;
import co.edu.uniquindio.minimercado.entidades.Empleado;
import co.edu.uniquindio.minimercado.entidades.Factura;
import co.edu.uniquindio.minimercado.servicios.EmpleadoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
@Getter
@Setter
public class FacturaBean implements Serializable {


    private Factura factura;

    private Cliente cliente;

    private Empleado empleado;

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @PostConstruct
    public void init(){
        factura = new Factura();
    }

    public void crearFactura(){

        try {
            empleadoServicio.crearFactura(factura);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
