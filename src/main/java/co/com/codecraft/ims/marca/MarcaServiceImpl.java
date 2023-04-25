package co.com.codecraft.ims.marca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService{
    @Autowired
    private MarcaRepository marcaRepo;

    @Override
    public Marca newMarca(Marca newMarca) {
        return this.marcaRepo.save(newMarca);
    }

    @Override
    public Iterable<Marca> getAllMarcas() {
        return this.marcaRepo.findAll();
    }

    @Override
    public Marca getMarcaById(Long idMarca) {
        return this.marcaRepo.getMarcaById(idMarca);
    }

    @Override
    public Marca modifyMarca(Marca marca) {
        Optional<Marca> marcaFound = this.marcaRepo.findById(marca.getId());
        if (marcaFound.get() != null){
            marcaFound.get().setNombreMarca(marca.getNombreMarca());
            return this.newMarca(marcaFound.get());
        }
        return null;
    }

    @Override
    public Boolean deleteMarca(Long idMarca) {
        this.marcaRepo.deleteById(idMarca);
        return true;
    }
}
