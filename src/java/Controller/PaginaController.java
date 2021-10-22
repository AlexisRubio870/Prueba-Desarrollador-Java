package Controller;

import Entity.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@ManagedBean
@Named
@ViewScoped
public class PaginaController implements Serializable{
    public void verificarSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogeado");

            if (us == null) {
                context.getExternalContext().redirect("permisos.xhtml");
            }
        } catch (Exception e) {
        }
    }
}
