package co.edu.uniquindio.minimercado.bean;

import co.edu.uniquindio.minimercado.entidades.Cliente;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class ClienteBean implements Serializable {

    @Getter
    @Setter
    private Cliente cliente;

    public void registrarCliente(){

    }
}
