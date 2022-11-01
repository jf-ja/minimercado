package co.edu.uniquindio.minimercado.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
@Getter
@Setter
public class InicioBean implements Serializable {

    private String mensaje = "Mi primer pagina jsf minimercado";

    private String dato1, dato2;


    public void cambiarValores(){
        String aux = dato1 ;
        dato1 = dato2;
        dato2 = aux;
    }


}
