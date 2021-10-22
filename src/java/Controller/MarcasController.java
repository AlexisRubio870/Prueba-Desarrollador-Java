package Controller;

import EJB.MarcaspcFacadeLocal;
import Entity.Marcaspc;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class MarcasController implements Serializable{
    @EJB
    private MarcaspcFacadeLocal marcaspcFacadeLocal;
    
    private Marcaspc marcasPC;
    
    private List<Marcaspc> listaMarcasPC;

    public Marcaspc getMarcasPC() {
        return marcasPC;
    }

    public void setMarcasPC(Marcaspc marcasPC) {
        this.marcasPC = marcasPC;
    }

    public List<Marcaspc> getListaMarcasPC() {
        this.listaMarcasPC = marcaspcFacadeLocal.findAll();
        return listaMarcasPC;
    }

    public void setListaMarcasPC(List<Marcaspc> listaMarcasPC) {
        this.listaMarcasPC = listaMarcasPC;
    }
}
