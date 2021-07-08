package zen.demospring.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zen.demospring.dao.UsuarioDao;
import zen.demospring.domain.Usuario;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarUsuario() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario encontrarUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getRut()).orElse(null);
    }
}
