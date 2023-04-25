package co.com.codecraft.ims.producto;

public interface ProductoService {
    Producto newProducto(Producto newProducto);
    Iterable<Producto> getAllProductos();
    Producto getProductById(Long idProducto);
    Producto modifyProduct(Producto producto);
    Boolean deleteProduct(Long idProducto);
}
