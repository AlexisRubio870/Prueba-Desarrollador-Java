package EJB;

import Entity.Marcaspc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alexis Rubio
 */
@Local
public interface MarcaspcFacadeLocal {

    void create(Marcaspc marcaspc);

    void edit(Marcaspc marcaspc);

    void remove(Marcaspc marcaspc);

    Marcaspc find(Object id);

    List<Marcaspc> findAll();

    List<Marcaspc> findRange(int[] range);

    int count();
    
}
