package mx.edu.utez.Examen_Recu.usuarios.control;

import mx.edu.utez.Examen_Recu.usuarios.model.UsuarioRepository;
import mx.edu.utez.Examen_Recu.usuarios.model.UsuarioDto;
import mx.edu.utez.Examen_Recu.usuarios.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final SecureRandom secureRandom = new SecureRandom();

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioDto.getUsername());
        usuario.setPassword(generarContrasenaAleatoria());
        usuario.setEstado(usuarioDto.isEstado());

        usuario = usuarioRepository.saveAndFlush(usuario);
        return usuario;
    }

    public Usuario update(UsuarioDto usuarioDto) {
        Optional<Usuario> optional = usuarioRepository.findById(usuarioDto.getId());
        if (optional.isPresent()) {
            Usuario usuario = optional.get();
            usuario.setUsername(usuarioDto.getUsername());
            usuario.setEstado(usuarioDto.isEstado());

            usuario = usuarioRepository.saveAndFlush(usuario);
            return usuario;
        }
        // Manejar el caso de usuario no encontrado lanzando una excepción o devolviendo null
        return null;
    }

    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }

    // Método para generar una contraseña aleatoria con ciertas características
    private String generarContrasenaAleatoria() {
        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+";
        StringBuilder contraseñaAleatoria = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int index = secureRandom.nextInt(caracteres.length());
            contraseñaAleatoria.append(caracteres.charAt(index));
        }

        return contraseñaAleatoria.toString();
    }
}
