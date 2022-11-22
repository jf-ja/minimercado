package co.edu.uniquindio.minimercado.servicios;

import co.edu.uniquindio.minimercado.entidades.*;
import co.edu.uniquindio.minimercado.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorServicioImpl implements AdministradorServicio{

    @Autowired
    private AdministradorRepo administradorRepo;

    private ProductoRepo productoRepo;
    private CategoriaRepo categoriaRepo;
    private ProvedorRepo provedorRepo;
    private PedidoRepo pedidoRepo;

    public AdministradorServicioImpl(AdministradorRepo administradorRepo, ProductoRepo productoRepo, CategoriaRepo categoriaRepo) {
        this.administradorRepo = administradorRepo;
        this.productoRepo = productoRepo;
        this.categoriaRepo = categoriaRepo;
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

       // boolean productoExiste = productoExiste(producto.getCodigo());
        Producto productoExisteNombre = productoRepo.obtenerProductoPorNombre(producto.getNombre());
       /* if(productoExiste){
            throw new Exception("El producto con este codigo ya existe");
        }

        */
        if(productoExisteNombre != null){
            throw new Exception("El producto con este nombre ya existe");
        }
        return productoRepo.save(producto);
    }

    @Override
    public Producto obtenerProducto(Integer codigo) throws Exception {

        Optional<Producto> producto = productoRepo.findById(codigo);
        if(producto.isEmpty()){
            throw new Exception("No existe el producto con ese codigo ");
        }
        return producto.get();
    }

    @Override
    public List<Producto> obtenerProductosPorNombre(String nombre) throws Exception {

        List<Producto> productos= productoRepo.obtenerProductosPorNombre(nombre);
        if(productos == null){
            throw new Exception("No existe el producto con ese nombre ");
        }
        return productos;
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


    @Override
    public List<Categoria> listarCategorias() {return categoriaRepo.findAll();
    }




    @Override
    public Categoria obtenerCategoria(Integer codigo) {
        return categoriaRepo.findById(codigo).orElse(null);
    }

    @Override
    public Pedido realizarPedido(Pedido pedido) throws Exception {
        Optional<Provedor> provedor = provedorRepo.findById(pedido.getProvedor().getCedula());
        Optional<Administrador> administrador = administradorRepo.findById(pedido.getAdministrador().getCedula());

        if (provedor.isEmpty() ){
            throw new Exception("NO EXISTE EL PROVEEDOR CON ESTA CEDULA");
        }
        if (administrador.isEmpty() ){
            throw new Exception("NO EXISTE EL ADMINISTRADOR CON ESTA CEDULA");
        }

        return pedidoRepo.save(pedido);
    }

    @Override
    public Administrador obtenerAdministrador(String cedula) throws Exception {
        Optional<Administrador> administrador = administradorRepo.findById(cedula);
        if(administrador.isEmpty()){
            throw new Exception("No existe el administrador con esta cedula");
        }
        return administrador.get();
    }

    @Override
    public Provedor obtenerProvedor(String cedula) throws Exception {
        Optional<Provedor> provedor = provedorRepo.findById(cedula);
        if(provedor.isEmpty()){
            throw new Exception("No existe el provedor con esta cedula");
        }
        return provedor.get();
    }
}
