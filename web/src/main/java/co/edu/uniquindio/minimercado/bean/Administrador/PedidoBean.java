package co.edu.uniquindio.minimercado.bean.Administrador;

import co.edu.uniquindio.minimercado.entidades.*;
import co.edu.uniquindio.minimercado.servicios.AdministradorServicio;
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
public class PedidoBean implements Serializable {
    @Getter
    @Setter
    private Pedido pedido;

    @Getter
    @Setter
    private Administrador administrador;

    @Getter
    @Setter
    private Provedor provedor;

    @Autowired
    private AdministradorServicio administradorServicio;

    @Getter
    @Setter
    private List<Producto> productosSeleccionados;

    @Getter
    @Setter
    private List<Producto> productos;

    @Getter
    @Setter
    private Double totalCalculado;

    @Getter
    @Setter
    private String cedulaAdministrador;

    @Getter
    @Setter
    private String cedulaProveedor;

    @Getter
    @Setter
    private int cantidad;


    @PostConstruct
    public void init(){
        pedido = new Pedido();
        administrador= new Administrador();
        provedor = new Provedor();


        productosSeleccionados = new ArrayList<>();
        productos = administradorServicio.listarProductos();

        totalCalculado=0.0;
    }

    public void crearPedido(){
        try {
            administrador =administradorServicio.obtenerAdministrador(cedulaAdministrador);
            provedor =administradorServicio.obtenerProvedor(cedulaProveedor);
            totalCalculado = totalCalculado*cantidad;
            pedido.setProductos(productosSeleccionados);
            pedido.setTotal(totalCalculado);
            pedido.setAdministrador(administrador);
            pedido.setProvedor(provedor);
            pedido.setFecha(LocalDate.now());
            pedido.setCantidad(cantidad);
            administradorServicio.realizarPedido(pedido);
            pedido = new Pedido();
            administrador= new Administrador();
            provedor = new Provedor();

            productosSeleccionados.clear();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "REGISTRO EXITOSO");
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_pedido", fm);

        } catch (Exception e ) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_pedido", fm);
            throw new RuntimeException(e);
        }
    }

    public Double calcularTotalPedido() {

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


