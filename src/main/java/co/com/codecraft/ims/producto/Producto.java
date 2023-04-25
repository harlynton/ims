package co.com.codecraft.ims.producto;

import co.com.codecraft.ims.categoria.Categoria;
import co.com.codecraft.ims.marca.Marca;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Producto {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String referenciaProducto;

    @Column
    private String nombreProducto;

    @Column
    private String descripcionProducto;

    @Column
    private Float precioCompra;

    @Column
    private Float precioVenta;

    @Column
    private String imagenProducto;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
