package co.edu.uniquindio.minimercado.servicios;

import co.edu.uniquindio.minimercado.entidades.Administrador;
import co.edu.uniquindio.minimercado.entidades.Producto;
import co.edu.uniquindio.minimercado.repo.AdministradorRepo;
import co.edu.uniquindio.minimercado.repo.ProductoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServicioImpl implements AdministradorServicio{

    @Autowired
    private AdministradorRepo administradorRepo;

    private ProductoRepo productoRepo;

    public AdministradorServicioImpl(AdministradorRepo administradorRepo, ProductoRepo productoRepo) {
        this.administradorRepo = administradorRepo;
        this.productoRepo = productoRepo;
    }

    @Override
    public Administrador login(String correo, String password) throws Exception {
        Administrador administrador = administradorRepo.compraboarAuntenticacion(correo, password);

        if(administrador == null){
            throw new Exception("Los Datos de Autentificacion son INCORRECTOS");
        }
        return administrador;
    }


    @Override
    public Producto crearProducto(Producto producto) throws Exception {

        boolean productoExiste = productoExiste(producto.getCodigo());
        if(productoExiste){
            throw new Exception("El producto con este codigo ya existe");
        }
        return productoRepo.save(producto);
    }

    public boolean productoExiste(Integer codigo){
        return productoRepo.findById(codigo).orElse(null)!=null;
    }

    @Override
    public Producto actualizarProducto(Producto producto) throws Exception {

        Optional<Producto> productoGuardado = productoRepo.findById(producto.getCodigo());
        if(productoGuardado.isEmpty()){
            throw new Exception("El producto no existe");
        }
        return productoRepo.save(producto);
    }

    @Override
    public void eliminarProducto(Integer codigo) throws Exception {
        Optional<Producto> productoGuardado = productoRepo.findById(codigo);
        if(productoGuardado.isEmpty()){
            throw new Exception("El producto no existe");
        }
         productoRepo.delete(productoGuardado.get());
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepo.findAll();
    }
}
