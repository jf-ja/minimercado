package co.edu.uniquindio.minimercado.bean;

import co.edu.uniquindio.minimercado.entidades.Administrador;
import co.edu.uniquindio.minimercado.entidades.Empleado;
import co.edu.uniquindio.minimercado.servicios.AdministradorServicio;
import co.edu.uniquindio.minimercado.servicios.EmpleadoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Component
@Scope("session")
public class SeguridadBean {


    @Getter
    @Setter
    private String email, password;

    @Autowired
    private AdministradorServicio administradorServicio;

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @Getter
    @Setter
    private Administrador adminSesion;

    @Getter
    @Setter
    private Empleado empleSesion;


    public String iniciarSesionAdmins() {

        if (!email.isEmpty() && !password.isEmpty()) {
            try{
            adminSesion= administradorServicio.login(email,password);

            if(adminSesion != null){
                return "/administrador/menuAdministrador?faces-redirect=true";
            }

            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "El correo y la contrasena son obligatorios");
            FacesContext.getCurrentInstance().addMessage("login-bean", fm);
        }
        return null;
    }


    public String iniciarSesionEmpleado() {

        if (!email.isEmpty() && !password.isEmpty()) {
            try{
                empleSesion= empleadoServicio.login(email,password);

                if(empleSesion != null){
                    return "/empleado/menuEmpleado?faces-redirect=true";
                }
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "El correo y la contrasena son obligatorios");
            FacesContext.getCurrentInstance().addMessage("login-bean", fm);
        }
        return null;
    }
}
