package co.com.codecraft.ims.marca;

import co.com.codecraft.ims.categoria.Categoria;

public interface MarcaService {
    Marca newMarca(Marca newMarca);
    Iterable<Marca> getAllMarcas();
    Marca getMarcaById(Long idMarca);
    Marca modifyMarca(Marca marca);
    Boolean deleteMarca(Long idMarca);
}
