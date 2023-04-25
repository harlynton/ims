package co.com.codecraft.ims.marca;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Marca {
    @Id
    @Column
    @GeneratedValue
    private Long Id;

    @Column(length = 50, nullable = false, unique = true)
    private String nombreMarca;

}
