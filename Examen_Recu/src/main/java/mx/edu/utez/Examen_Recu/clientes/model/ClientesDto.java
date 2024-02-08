package mx.edu.utez.Examen_Recu.clientes.model;

import lombok.Data;

@Data
public class ClientesDto {
    private Long id;
    private String username;
    private boolean estado;
    private String nombres;
    private String apellido;
    private String direccion;
    private String numeroTelefono;
    private int edad;

}
