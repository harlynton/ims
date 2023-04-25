package co.com.codecraft.ims.categoria;

public interface CategoriaService {
    Categoria newCategoria(Categoria newCategoria);
    Iterable<Categoria> getAllCategorias();
    Categoria getCategoriaById(Long idCategoria);
    Categoria modifyCategoria(Categoria categoria);
    Boolean deleteCategoria(Long idCategoria);
}
