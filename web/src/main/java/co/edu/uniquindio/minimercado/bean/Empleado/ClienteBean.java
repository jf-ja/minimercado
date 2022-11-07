package co.edu.uniquindio.minimercado.bean.Empleado;

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
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class ClienteBean implements Serializable {

    @Getter
    @Setter
    private Cliente cliente;

    @Getter
    @Setter
    private List<Cliente> clientes;


    @Getter
    @Setter
    private List<Cliente> clientesSeleccionados;

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @PostConstruct
    public void init(){
        cliente = new Cliente();
        clientesSeleccionados = new ArrayList<>();
        clientes = empleadoServicio.listarClientes();
    }
    public void registrarCliente(){
        try {
            Cliente registro = empleadoServicio.registrarCliente(cliente);
            clientes.add(registro);

            cliente = new Cliente();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "REGISTRO EXITOSO");
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_cliente", fm);

        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_cliente", fm);
            throw new RuntimeException(e);
        }
    }



    public void eliminarClientes(){

            try {
                for (Cliente cliente : clientesSeleccionados){
                empleadoServicio.eliminarCliente(cliente.getCedula());
                clientes.remove(cliente);
                }
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje_eliminar_cliente", fm);
            }



    }
}
