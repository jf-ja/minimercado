package co.edu.uniquindio.minimercado.bean;

import co.edu.uniquindio.minimercado.entidades.Cliente;
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

@Component
@ViewScoped
public class ClienteBean implements Serializable {

    @Getter
    @Setter
    private Cliente cliente;

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @PostConstruct
    public void init(){
        cliente = new Cliente();
    }
    public void registrarCliente(){
        try {
            empleadoServicio.registrarCliente(cliente);

            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "REGISTRO EXITOSO");
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_cliente", fm);

        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_cliente", fm);
            throw new RuntimeException(e);
        }
    }
}
