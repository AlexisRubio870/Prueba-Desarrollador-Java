package EJB;

import Entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alexis Rubio
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "PruebaEncuestaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario loginUsuario(String nombre, String clave) {
        try {
            Query qt = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreU AND u.contraseñaUsuario = :contraseñaU");
            qt.setParameter("nombreU", nombre);
            qt.setParameter("contraseñaU", clave);
            return (Usuario) qt.getSingleResult();

        } catch (Exception e) {
            return new Usuario();
        }
    }
    
}
