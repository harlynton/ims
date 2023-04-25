package co.com.codecraft.ims.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria getCategoriaById(Long idCategoria);
}

