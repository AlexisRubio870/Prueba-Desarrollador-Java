package EJB;

import Entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alexis Rubio
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();

    public Usuario loginUsuario(String nombre, String clave);
    
}
