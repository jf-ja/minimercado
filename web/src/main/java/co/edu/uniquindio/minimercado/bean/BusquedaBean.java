package co.edu.uniquindio.minimercado.bean;

import co.edu.uniquindio.minimercado.entidades.Empleado;
import co.edu.uniquindio.minimercado.entidades.Producto;
import co.edu.uniquindio.minimercado.servicios.AdministradorServicio;
import co.edu.uniquindio.minimercado.servicios.EmpleadoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class BusquedaBean {

    @Getter
    @Setter
    private String busqueda;

    @Getter @Setter
    private String nombreProducto;

    @Getter @Setter
    private List<Producto> productos;

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @PostConstruct
    public void init() throws Exception {
        productos= new ArrayList<>();
    }


    public void buscarProductosNombre(){
        try {
            productos = empleadoServicio.obtenerProductosPorNombre(nombreProducto);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Consulta Exitosa");
            FacesContext.getCurrentInstance().addMessage("mensaje_consulta_producto", fm);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_consulta_producto", fm);
            throw new RuntimeException(e);
        }
    }
}
