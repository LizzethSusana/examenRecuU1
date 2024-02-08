package mx.edu.utez.Examen_Recu.clientes.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", columnDefinition = "VARCHAR(50)")
    private String username;

    @Column(name = "estado")
    private boolean estado;

    @Column(name = "nombres", columnDefinition = "VARCHAR(50)")
    private String nombres;

    @Column(name = "apellido", columnDefinition = "VARCHAR(50)")
    private String apellido;

    @Column(name = "direccion", columnDefinition = "VARCHAR(255)")
    private String direccion;

    @Column(name = "numeroTelefono", columnDefinition = "VARCHAR(20)")
    private String numeroTelefono;

    @Column(name = "edad")
    private int edad;


}
