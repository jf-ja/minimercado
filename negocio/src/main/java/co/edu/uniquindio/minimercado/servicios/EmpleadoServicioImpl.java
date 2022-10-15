package co.edu.uniquindio.minimercado.servicios;

import co.edu.uniquindio.minimercado.entidades.Factura;
import co.edu.uniquindio.minimercado.repo.EmpleadoRepo;
import co.edu.uniquindio.minimercado.repo.FacturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio{

    @Autowired
    private EmpleadoRepo empleadoRepo;

    private FacturaRepo facturaRepo;

    public EmpleadoServicioImpl(EmpleadoRepo empleadoRepo, FacturaRepo facturaRepo) {
        this.empleadoRepo = empleadoRepo;
        this.facturaRepo = facturaRepo;
    }

    @Override
    public Factura crearFactura(Factura factura) throws Exception {

        boolean facturaExiste = facturaExiste(factura.getCodigo());

        if (facturaExiste){
            throw new Exception("La factura con este codigo ya existe");
        }
        return facturaRepo.save(factura);
    }

    public boolean facturaExiste(Integer codigo){
        return facturaRepo.findById(codigo).orElse(null)!=null;
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
}
