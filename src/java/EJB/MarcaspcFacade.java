package EJB;

import Entity.Marcaspc;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alexis Rubio
 */
@Stateless
public class MarcaspcFacade extends AbstractFacade<Marcaspc> implements MarcaspcFacadeLocal {

    @PersistenceContext(unitName = "PruebaEncuestaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarcaspcFacade() {
        super(Marcaspc.class);
    }
    
}
