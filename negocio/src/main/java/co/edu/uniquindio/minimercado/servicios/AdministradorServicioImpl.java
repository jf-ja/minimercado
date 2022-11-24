package co.edu.uniquindio.minimercado.servicios;

import co.edu.uniquindio.minimercado.dto.CantidadFacturaEmpleadoDTO;
import co.edu.uniquindio.minimercado.dto.CompraDTO;
import co.edu.uniquindio.minimercado.entidades.*;
import co.edu.uniquindio.minimercado.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
    private ClienteRepo clienteRepo;
    private FacturaRepo facturaRepo;

    private EmpleadoRepo empleadoRepo;

    public AdministradorServicioImpl(AdministradorRepo administradorRepo, ProductoRepo productoRepo, CategoriaRepo categoriaRepo, ProvedorRepo provedorRepo, PedidoRepo pedidoRepo, ClienteRepo clienteRepo, FacturaRepo facturaRepo, EmpleadoRepo empleadoRepo) {
        this.administradorRepo = administradorRepo;
        this.productoRepo = productoRepo;
        this.categoriaRepo = categoriaRepo;
        this.provedorRepo = provedorRepo;
        this.pedidoRepo = pedidoRepo;
        this.clienteRepo = clienteRepo;
        this.facturaRepo = facturaRepo;
        this.empleadoRepo = empleadoRepo;
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
        Optional<Administrador> administrador = administradorRepo.findById(pedido.getAdministrador().getCedula());
        Optional<Provedor> provedor = provedorRepo.findById(pedido.getProvedor().getCedula());

        if (administrador.isEmpty() ){
            throw new Exception("NO EXISTE EL ADMINISTRADOR CON ESTA CEDULA");
        }
        if (provedor.isEmpty() ){
            throw new Exception("NO EXISTE EL PROVEDOR CON ESTA CEDULA");
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

    @Override
    public List<CompraDTO> obtenerPromedioComprasCliente(String cedula) throws Exception {

        Optional<Cliente> clienteGuardado = clienteRepo.findById(cedula);
        if(clienteGuardado.isEmpty()){
            throw new Exception("El cliente NO EXISTE");
        }

        List<CompraDTO> promCompras = facturaRepo.obtenerPromedioComprasCliente(cedula);

        if (promCompras == null){
            throw new Exception("El cliente NO tiene compras");
        }
        return promCompras;
    }

    @Override
    public List<CantidadFacturaEmpleadoDTO> obtenerCantidadComprasEmpleado(String cedula) throws Exception {

        Optional<Empleado> empleadoGuardado = empleadoRepo.findById(cedula);
        if(empleadoGuardado.isEmpty()){
            throw new Exception("El cliente NO EXISTE");
        }

        List<CantidadFacturaEmpleadoDTO> cantidadFacturas = facturaRepo.obtenerCantidadFacturasEmpleado(cedula);

        if (cantidadFacturas == null){
            throw new Exception("El cliente NO tiene compras");
        }
        return cantidadFacturas;
    }

    @Override
    public List<Factura> obtenerMaximaFactura() throws Exception {
        Factura factura = facturaRepo.obtenerMaximaFactura();
        List<Factura> maxFactura= new ArrayList<>();
        maxFactura.add(factura);
        if(factura == null){
            throw new Exception("NO EXISTEN FACTURAS");
        }
        return maxFactura;
    }

    @Override
    public List<Producto> obtenerProductosCompra(Integer codigo) throws Exception {
        List<Producto> productosCompra = facturaRepo.obtenerProductosCompra(codigo);
        if(productosCompra.isEmpty()){
            throw new Exception("No existe la factura con este codigo");
        }
        return productosCompra;
    }

    @Override
    public List<Factura> obtenerFacturasFecha(LocalDate fecha) throws Exception {
        List<Factura> facturasFecha = facturaRepo.obtenerFacturasFecha(fecha);
        if(facturasFecha.isEmpty()){
            throw new Exception("No hay facturas en esta fecha");
        }
        return facturasFecha;
    }

    @Override
    public List<Pedido> obtenerPedidos() {
       List<Pedido> pedidos = pedidoRepo.obtenerPedidosTodos();
       return pedidos;
    }


}
