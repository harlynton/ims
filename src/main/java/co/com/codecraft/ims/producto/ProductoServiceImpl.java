package co.com.codecraft.ims.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoRepository productRepo;
    @Override
    public Producto newProducto(Producto newProducto) {
        return productRepo.save(newProducto);
    }

    @Override
    public Iterable<Producto> getAllProductos() {
        return this.productRepo.findAll();
    }

    @Override
    public Producto getProductById(Long idProducto){
        return this.productRepo.getProductById(idProducto);
    }

    @Override
    public Producto modifyProduct(Producto producto) {
        Optional<Producto> productFound= this.productRepo.findById(producto.getId());
        if (productFound.get() != null){
            productFound.get().setReferenciaProducto(producto.getReferenciaProducto());
            productFound.get().setNombreProducto(producto.getNombreProducto());
            productFound.get().setDescripcionProducto(producto.getDescripcionProducto());
            productFound.get().setImagenProducto(producto.getImagenProducto());
            productFound.get().setMarca(producto.getMarca());
            productFound.get().setCategoria(producto.getCategoria());

            return this.newProducto(productFound.get());
        }
        return null;
    }

    @Override
    public Boolean deleteProduct(Long idProducto) {
        this.productRepo.deleteById(idProducto);
        return true;
    }
}
