package zen.demospring.domain;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NotEmpty
    private String rut;

    @NotEmpty
    private String nombre;


    private int edad;

    private int telefono;
}
