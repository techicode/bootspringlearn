package zen.demospring.servicio;

import zen.demospring.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> listarUsuario();

    public void guardar (Usuario usuario);

    public void eliminar (Usuario usuario);

    public Usuario encontrarUsuario (Usuario usuario);

}
