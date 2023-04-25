package co.com.codecraft.ims.marca;

import co.com.codecraft.ims.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    Marca getMarcaById(Long idMarca);
}
