package co.edu.uniquindio.minimercado.converter;

import co.edu.uniquindio.minimercado.entidades.Categoria;
import co.edu.uniquindio.minimercado.servicios.AdministradorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component
public class CategoriaConverter implements Converter<Categoria> {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Override
    public Categoria getAsObject(FacesContext context, UIComponent component, String value) {

        Categoria categoria ;
        try {
             categoria = administradorServicio.obtenerCategoria(Integer.parseInt(value));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return categoria;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Categoria value) {

        if(value != null){
            return ""+value.getCodigo();
        }
        return "";
    }
}
