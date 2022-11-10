package co.edu.uniquindio.minimercado.bean.Empleado;

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

    //-----actualziar-----

    @Getter
    @Setter
    private List<Producto> productos;

    @Getter
    @Setter
    private List<Producto> productosSeleccionados;

    private boolean editar;

    @PostConstruct
    public void init(){
        producto = new Producto();
        categorias= administradorServicio.listarCategorias();

        productosSeleccionados = new ArrayList<>();
        productos = administradorServicio.listarProductos();
        editar=false;
    }

    public void registrarProducto(){
        try {
            if(!editar) {
                Producto registro = administradorServicio.crearProducto(producto);
                productos.add(registro);

                producto = new Producto();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "REGISTRO EXITOSO");
                FacesContext.getCurrentInstance().addMessage("mensaje_registro_producto", fm);
            }else{

                administradorServicio.actualizarProducto(producto);
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "ACTUALIZACION EXITOSA");
                FacesContext.getCurrentInstance().addMessage("mensaje_registro_producto", fm);
            }

        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_registro_producto", fm);
            throw new RuntimeException(e);
        }
    }



    public void eliminarProductos(){

        try {
            for (Producto producto : productosSeleccionados){
                administradorServicio.eliminarProducto(producto.getCodigo());
                productos.remove(producto);
            }
            productosSeleccionados.clear();
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_eliminar_producto", fm);
        }
    }


    public String getMensajeBorrar(){
        if(productosSeleccionados.isEmpty()){
            return "Borrar";
        }else{
            return "Borrar (" + productosSeleccionados.size() + ")" ;
        }

    }

    public String getMensajeCrearEditar(){
        if(editar){
            return "EDITAR PRODUCTO";
        }
        return "CREAR PRODUCTO" ;
    }


    public void seleccionarProducto(Producto productoSelec){
        this.producto=productoSelec;
        editar=true;
    }

    public void crearProductoDialog(){
        this.producto= new Producto();
        editar=false;
    }



}
