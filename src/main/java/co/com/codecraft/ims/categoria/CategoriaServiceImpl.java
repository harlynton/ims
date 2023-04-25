package co.com.codecraft.ims.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepo;

    @Override
    public Categoria newCategoria(Categoria newCategoria) {
        return this.categoriaRepo.save(newCategoria);
    }

    @Override
    public Iterable<Categoria> getAllCategorias() {
        return this.categoriaRepo.findAll();
    }

    @Override
    public Categoria getCategoriaById(Long idCategoria) {
        return this.categoriaRepo.getCategoriaById(idCategoria);
    }

    @Override
    public Categoria modifyCategoria(Categoria categoria) {
        Optional<Categoria> categoriaFound =this.categoriaRepo.findById(categoria.getId());
        if (categoriaFound.get() !=null){
            categoriaFound.get().setDescripcion(categoria.getDescripcion());
            return this.newCategoria(categoriaFound.get());
        }
        return null;
    }

    @Override
    public Boolean deleteCategoria(Long idCategoria) {
        this.categoriaRepo.deleteById(idCategoria);
        return true;
    }
}
