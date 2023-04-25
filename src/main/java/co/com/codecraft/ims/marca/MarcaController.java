package co.com.codecraft.ims.marca;

import co.com.codecraft.ims.categoria.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= {"http://localhost:4200", "http://localhost:8080"})
@RestController
@RequestMapping("/marcas")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;

    @GetMapping("/{id}")
    public Marca getMarcaById(@PathVariable Long id){
        return this.marcaService.getMarcaById(id);
    }

    @GetMapping("/new")
    public ResponseEntity<Marca> newMarca(@RequestBody Marca marca){
        return ResponseEntity.status(HttpStatus.CREATED).body(marcaService.newMarca(marca));
    }

    @GetMapping("/list")
    public Iterable<Marca> getAll(){
        return marcaService.getAllMarcas();
    }

    @PostMapping("/update")
    public ResponseEntity<Marca> updateMarca(@RequestBody Marca marca){
        return ResponseEntity.status(HttpStatus.CREATED).body(marcaService.modifyMarca(marca));
    }

    @PostMapping(value="/delete/{id}")
    public ResponseEntity<Boolean> deleteMarca(@PathVariable(value="id")Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.marcaService.deleteMarca(id));
    }
}

