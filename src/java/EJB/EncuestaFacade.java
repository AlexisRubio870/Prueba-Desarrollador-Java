package EJB;

import Entity.Encuesta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EncuestaFacade extends AbstractFacade<Encuesta> implements EncuestaFacadeLocal {

    @PersistenceContext(unitName = "PruebaEncuestaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncuestaFacade() {
        super(Encuesta.class);
    }
    
}
