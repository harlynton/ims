package co.com.codecraft.ims.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= {"http://localhost:4200", "http://localhost:8080"})
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public Categoria getCategoriaById(@PathVariable Long id){
        return this.categoriaService.getCategoriaById(id);
    }

    @GetMapping("/new")
    public ResponseEntity<Categoria> newCategoria(@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.newCategoria(categoria));
    }

    @GetMapping("/list")
    public Iterable<Categoria> getAll(){
        return categoriaService.getAllCategorias();
    }

    @PostMapping("/update")
    public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.modifyCategoria(categoria));
    }

    @PostMapping(value="/delete/{id}")
    public ResponseEntity<Boolean> deleteCategoria(@PathVariable(value="id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.categoriaService.deleteCategoria(id));
    }
}
