package co.edu.uniquindio.minimercado.bean.Empleado;

import co.edu.uniquindio.minimercado.entidades.Cliente;
import co.edu.uniquindio.minimercado.entidades.Empleado;
import co.edu.uniquindio.minimercado.entidades.Factura;
import co.edu.uniquindio.minimercado.entidades.Producto;
import co.edu.uniquindio.minimercado.servicios.AdministradorServicio;
import co.edu.uniquindio.minimercado.servicios.EmpleadoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped

public class FacturaBean implements Serializable {

    @Getter
    @Setter
    private Factura factura;

    @Getter
    @Setter
    private Cliente cliente;

    @Getter
    @Setter
    private Empleado empleado;

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @Autowired
    private AdministradorServicio administradorServicio;

    @Getter
    @Setter
    private String cedula;

    @Getter
    @Setter
    private Double totalCalculado;
    @Getter
    @Setter
    private List<Producto> productos;

    @Getter
    @Setter
    private List<Producto> productosSeleccionados;

    @PostConstruct
    public void init(){
        factura = new Factura();
        empleado= new Empleado();
        cliente = new Cliente();


        productosSeleccionados = new ArrayList<>();
        productos = administradorServicio.listarProductos();

        totalCalculado=0.0;
    }

    public void crearFactura(){

        try {
            empleado = empleadoServicio.obtenerEmpleadoPorCedula("0111");
            cliente = empleadoServicio.obtenerClientePorCedula(cedula);
            factura.setProductos(productosSeleccionados);
            factura.setTotal(totalCalculado);
            factura.setCliente(cliente);
            factura.setEmpleado(empleado);
            empleadoServicio.crearFactura(factura);
            cliente = new Cliente();
            factura = new Factura();
            empleado = new Empleado();

            productosSeleccionados.clear();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "REGISTRO EXITOSO");
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_factura", fm);

        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_factura", fm);
            throw new RuntimeException(e);
        }
    }


    public Double calcularTotalFactura() {

        totalCalculado = 0.0;
        if (!productosSeleccionados.isEmpty()) {
            for (Producto producto : productosSeleccionados) {
                totalCalculado += producto.getPrecio();
            }
            return totalCalculado;
        }
        return totalCalculado;
    }
}
