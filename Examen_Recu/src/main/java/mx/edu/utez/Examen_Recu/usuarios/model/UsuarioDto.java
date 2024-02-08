package mx.edu.utez.Examen_Recu.usuarios.model;

import lombok.Data;

@Data
public class UsuarioDto {

    private Long id;
    private String username;
    private String password;
    private boolean estado;
}
