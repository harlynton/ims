package co.com.codecraft.ims.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= {"http://localhost:4200", "http://localhost:8080"})
@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/{id}")
    public Producto getProductById(@RequestParam Long idProducto){
        return this.productoService.getProductById(idProducto);
    }
   /* @GetMapping("/new")
    public Producto newProducto(Producto newProducto){
        return this.productoService.newProducto(newProducto);
    }

    */
    @GetMapping("/new")
    public ResponseEntity<Producto> newProducto(@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.newProducto(producto));
    }

    @GetMapping("/list")
    public Iterable<Producto> getAll(){
        return productoService.getAllProductos();
    }

   /*
    @PostMapping("/update")
    public Producto updateProducto(@RequestBody Producto producto){
        return this.productoService.modifyProduct(producto);
    }
    */

    @PostMapping("/update")
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.modifyProduct(producto));
    }

    /*
    @PostMapping(value = "/delete/{id}")
    public Boolean deleteProduct(@PathVariable( value= "id") Long id){
        return this.productoService.deleteProduct(id);
    }

     */

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Boolean> deleteProducto(@PathVariable(value="id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.productoService.deleteProduct(id));
    }
}
