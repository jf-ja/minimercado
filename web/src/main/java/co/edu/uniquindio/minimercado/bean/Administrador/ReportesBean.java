package co.edu.uniquindio.minimercado.bean.Administrador;

import co.edu.uniquindio.minimercado.dto.CantidadFacturaEmpleadoDTO;
import co.edu.uniquindio.minimercado.dto.CompraDTO;
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
public class ReportesBean implements Serializable {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Getter
    @Setter
    private String cedulaCliente;

    @Getter
    @Setter
    private String cedulaEmpleado;

    @Getter
    @Setter
    private LocalDate fecha;

    @Getter
    @Setter
    private List<CompraDTO> promedioCompras;

    @Getter
    @Setter
    private List<CantidadFacturaEmpleadoDTO> candidadFacturas;

    @Getter
    @Setter
    private List<Factura> maxFactura;

    @Getter
    @Setter
    private List<Producto> productosCompra;

    @Getter
    @Setter
    private Integer codigoFactura;

    @Getter
    @Setter
    private List<Factura> facturasFecha;

    @Getter
    @Setter
    private List<Pedido> pedidos;

    @PostConstruct
    public void init(){
        promedioCompras = new ArrayList<>();
        candidadFacturas = new ArrayList<>();
        maxFactura = new ArrayList<>();
        productosCompra = new ArrayList<>();
        facturasFecha= new ArrayList<>();
        pedidos = new ArrayList<>();

    }

    //--------------------------------------------------------------------------------------

    public void obtenerPromediosCompraCliente(){
        try {
            promedioCompras= administradorServicio.obtenerPromedioComprasCliente(cedulaCliente);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Consulta Exitosa");
            FacesContext.getCurrentInstance().addMessage("mensaje_promedio-compras", fm);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_promedio-compras", fm);
            throw new RuntimeException(e);
        }
    }


    //--------------------------------------------------------------------------------------

    public void obtenerCantidadFacturasEmpleado(){
        try {
            candidadFacturas = administradorServicio.obtenerCantidadComprasEmpleado(cedulaEmpleado);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Consulta Exitosa");
            FacesContext.getCurrentInstance().addMessage("mensaje_cantidad_compras", fm);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_cantidad_compras", fm);
            throw new RuntimeException(e);
        }
    }

    //---------------------------------------------------------------------------------------

    public void obtenerMaximaFactura(){
        try {
            maxFactura= administradorServicio.obtenerMaximaFactura();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Consulta Exitosa");
            FacesContext.getCurrentInstance().addMessage("mensaje_max_factura", fm);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_max_factura", fm);
            throw new RuntimeException(e);
        }
    }


    public void obtenerProductosFactura(){
        try {
            productosCompra= administradorServicio.obtenerProductosCompra(codigoFactura);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Consulta Exitosa");
            FacesContext.getCurrentInstance().addMessage("mensaje_productos_factura", fm);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_productos_factura", fm);
            throw new RuntimeException(e);
        }
    }

    public void obtenerFacturasFecha(){
        try {
            facturasFecha= administradorServicio.obtenerFacturasFecha(fecha);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Consulta Exitosa");
            FacesContext.getCurrentInstance().addMessage("mensaje_factura_fecha", fm);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_factura_fecha", fm);
            throw new RuntimeException(e);
        }
    }


    public void obtenerTodosPedidos(){
        try {
            pedidos= administradorServicio.obtenerPedidos();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Consulta Exitosa");
            FacesContext.getCurrentInstance().addMessage("mensaje_pedidos", fm);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_pedidos", fm);
            throw new RuntimeException(e);
        }
    }


}
