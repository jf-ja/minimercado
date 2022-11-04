package co.edu.uniquindio.minimercado.bean;

import co.edu.uniquindio.minimercado.entidades.*;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@ViewScoped
public class ProductoBean implements Serializable {
    @Getter @Setter
    private Producto producto;

    @Getter @Setter
    private List<Categoria> categorias;

    @Autowired
    private AdministradorServicio administradorServicio;

    @PostConstruct
    public void init(){
        producto = new Producto();
        categorias= administradorServicio.listarCategorias();
    }

    public void registrarProducto(){
        try {
            administradorServicio.crearProducto(producto);

            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "REGISTRO EXITOSO");
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_producto", fm);

        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_producto", fm);
            throw new RuntimeException(e);
        }
    }




}
