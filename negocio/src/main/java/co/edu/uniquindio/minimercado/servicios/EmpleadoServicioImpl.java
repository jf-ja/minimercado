package co.edu.uniquindio.minimercado.servicios;

import co.edu.uniquindio.minimercado.entidades.Cliente;
import co.edu.uniquindio.minimercado.entidades.Empleado;
import co.edu.uniquindio.minimercado.entidades.Factura;
import co.edu.uniquindio.minimercado.repo.ClienteRepo;
import co.edu.uniquindio.minimercado.repo.EmpleadoRepo;
import co.edu.uniquindio.minimercado.repo.FacturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio{

    @Autowired
    private FacturaRepo facturaRepo;
    private ClienteRepo clienteRepo;

    private EmpleadoRepo empleadoRepo;

    public EmpleadoServicioImpl(FacturaRepo facturaRepo, ClienteRepo clienteRepo, EmpleadoRepo empleadoRepo) {
        this.facturaRepo = facturaRepo;
        this.clienteRepo = clienteRepo;
        this.empleadoRepo = empleadoRepo;
    }

    //------------------------------------FACTURA----------------------------------------

    @Override
    public Factura crearFactura(Factura factura) throws Exception {

        boolean facturaExiste = facturaExiste(factura.getCodigo());

        if (facturaExiste){
            throw new Exception("La factura con este codigo ya existe");
        }

        Optional<Cliente> cliente = clienteRepo.findById(factura.getCliente().getCedula());
        Optional<Empleado> empleado = empleadoRepo.findById(factura.getEmpleado().getCedula());

        if (cliente.isEmpty() ){
            throw new Exception("NO EXISTE EL CLIENTE CON ESTA CEDULA");
        }
        if (empleado.isEmpty() ){
            throw new Exception("NO EXISTE EL EMPLEADO CON ESTA CEDULA");
        }

        return facturaRepo.save(factura);
    }

    public boolean facturaExiste(Integer codigo){
        return facturaRepo.findById(codigo).orElse(null)!=null;
    }

    @Override
    public Factura obtenerFacturaPorCodigo(Integer codigo) throws Exception {

        Optional<Factura> facturaGuardado = facturaRepo.findById(codigo);

        if(facturaGuardado.isEmpty()){
            throw new Exception("La factura NO EXISTE");
        }

        return facturaGuardado.get();
    }

    @Override
    public Factura actualizarFactura(Factura factura) throws Exception {

        Optional<Factura> facturaGuardada = facturaRepo.findById(factura.getCodigo());

        if(facturaGuardada.isEmpty()){
            throw new Exception("La factura NO EXISTE");
        }
        return facturaRepo.save(factura);
    }

    @Override
    public void eliminarFactura(Integer codigo) throws Exception {

        Optional<Factura> facturaGuardada = facturaRepo.findById(codigo);
        if(facturaGuardada.isEmpty()){
            throw new Exception("La factura NO EXISTE");
        }
        facturaRepo.delete(facturaGuardada.get());
    }

    @Override
    public List<Factura> listarFacturas() {
        return facturaRepo.findAll();
    }


    //---------------------------------- CRUD DE CLIENTE --------------------------------

    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception{

        boolean correoExiste = esRepetido(cliente.getCorreo());
        if(correoExiste){
            throw new Exception("El Correo ya esta en Uso");
        }
        //cedula
        boolean cedulaExiste = cedulaRepetida(cliente.getCedula());
        if(cedulaExiste){
            throw  new Exception("La cedula ingresada ya existe");
        }

        return clienteRepo.save(cliente);
    }

    private boolean esRepetido(String correo){
        return clienteRepo.findByCorreo(correo).orElse(null) != null;
    }

    private boolean cedulaRepetida(String cedula) {
        return clienteRepo.existsById(cedula);
    }


    @Override
    public Cliente obtenerClientePorCedula(String cedula) throws Exception {

        Optional<Cliente> clienteGuardado = clienteRepo.findById(cedula);

        if(clienteGuardado.isEmpty()){
            throw new Exception("El cliente NO EXISTE");
        }

        return clienteGuardado.get();
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws Exception{

        Optional<Cliente> clienteGuardado = clienteRepo.findById(cliente.getCedula());

        if (clienteGuardado.isEmpty()){
            throw new Exception("El cliente NO EXISTE");
        }
        return clienteRepo.save(cliente);
    }

    @Override
    public void eliminarCliente(String codigoCliente) throws Exception{

        Optional<Cliente> clienteGuardado = clienteRepo.findById(codigoCliente);

        if(clienteGuardado.isEmpty()){
            throw new Exception("El cliente NO EXISTE");
        }

        clienteRepo.delete(clienteGuardado.get());
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }


}
