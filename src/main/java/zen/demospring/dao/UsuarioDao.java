package zen.demospring.dao;


import org.springframework.data.repository.CrudRepository;
import zen.demospring.domain.Usuario;

// especificando la identidad que manejera el crudrepository, en este ej tipo Usuario ,+ el tipo de la primary key (String)
public interface UsuarioDao extends CrudRepository<Usuario, String> {

}
