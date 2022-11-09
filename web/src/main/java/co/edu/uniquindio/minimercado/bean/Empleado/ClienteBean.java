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

    //----actualizar---

    private boolean editar;

    @PostConstruct
    public void init(){
        cliente = new Cliente();
        clientesSeleccionados = new ArrayList<>();
        clientes = empleadoServicio.listarClientes();
        editar=false;
    }
    public void registrarCliente(){
        try {

            if(!editar) {

                Cliente registro = empleadoServicio.registrarCliente(cliente);
                clientes.add(registro);

                cliente = new Cliente();
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "REGISTRO EXITOSO");
                FacesContext.getCurrentInstance().addMessage("mensaje_registro_cliente", fm);

            }else{
                empleadoServicio.actualizarCliente(cliente);
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "ACTUALIZACION EXITOSA");
                FacesContext.getCurrentInstance().addMessage("mensaje_registro_cliente", fm);
            }
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
                clientesSeleccionados.clear();
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensaje_eliminar_cliente", fm);
            }
    }


    public String getMensajeBorrar(){
        if(clientesSeleccionados.isEmpty()){
            return "Borrar";
        }else{
            return "Borrar (" + clientesSeleccionados.size() + ")" ;
        }

    }

    public String getMensajeCrearEditar(){
        if(editar){
            return "EDITAR CLIENTE";
        }
            return "CREAR CLIENTE" ;
    }


    public void seleccionarCliente(Cliente clienteSelec){
        this.cliente=clienteSelec;
        editar=true;
    }

    public void crearClienteDialog(){
        this.cliente= new Cliente();
        editar=false;
    }
}
