package Controller;

import EJB.UsuarioFacadeLocal;
import Entity.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named(value = "usuarioSession")
@SessionScoped
public class UsuarioSession implements Serializable {
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private String nombre;
    private String clave;
    private Usuario usuLogin = new Usuario();
    
    public UsuarioSession(){
    }
    
    public void validarUsuario() {
        String mensaje = "";
        try {
            usuLogin = usuarioFacadeLocal.loginUsuario(nombre, clave);
            if (usuLogin.getNombreUsuario()== null) {
                mensaje = "swal(\"Credenciales Incorrectas!\", \"Selecciona 'Ok' para continuar!\", \"error\");";
            } else {
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().getSessionMap().put("usuarioLogeado", usuLogin);
                fc.getExternalContext().redirect("index.xhtml");
            }

        } catch (Exception e) {
            mensaje = "swal('Error al iniciar sesión !!!!', 'En el sistema', 'error');";
        }
        PrimeFaces.current().executeScript(mensaje);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Usuario getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(Usuario usuLogin) {
        this.usuLogin = usuLogin;
    }
    
    
    
}
