package co.edu.uniquindio.minimercado.bean;

import co.edu.uniquindio.minimercado.entidades.Empleado;
import co.edu.uniquindio.minimercado.entidades.Producto;
import co.edu.uniquindio.minimercado.servicios.AdministradorServicio;
import co.edu.uniquindio.minimercado.servicios.EmpleadoServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
public class BusquedaBean {

    @Getter
    @Setter
    private String busqueda;

    @Getter @Setter
    @Value("#{param['busqueda']}")
    private String busquedaParam;

    @Getter @Setter
    private List<Producto> productos;

    @Autowired
    private AdministradorServicio administradorServicio;

    @PostConstruct
    public void init() throws Exception {
        if(busquedaParam != null && !busquedaParam.isEmpty()){
            productos = administradorServicio.obtenerProductosPorNombre(busquedaParam);
        }
    }


    public String buscar(){
        if(!busqueda.isEmpty()){
            return "/resultados_busquedad?faces-redirect=true&amp;busqueda=" + busqueda;
        }
        return "";
    }
}
