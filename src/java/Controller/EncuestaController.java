package Controller;

import EJB.EncuestaFacadeLocal;
import Entity.Encuesta;
import Entity.Marcaspc;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.PrimeFaces;

@ManagedBean
@ViewScoped
public class EncuestaController implements Serializable{
    @EJB
    private EncuestaFacadeLocal encuestaFacadeLocal;
    
    private Marcaspc marcasPC;
    private Encuesta encuesta;
    private Date objDate = new Date(); 
    
    private List<Encuesta> listaEncuestas = new ArrayList<>();
    
    public void guardar() {
        String mensajewall = "";
        try {
            this.encuesta.setMarcaPCEncuesta(marcasPC);
            this.encuesta.setFechaRespuestaEncuesta(objDate);
            this.encuestaFacadeLocal.create(encuesta);

            this.encuesta = new Encuesta();
            this.marcasPC = new Marcaspc();
            listaEncuestas.clear();
            listaEncuestas.addAll(encuestaFacadeLocal.findAll());
            mensajewall = "swal(\"Encuesta Registrada!\", \"Selecciona 'Ok' para continuar!\", \"success\");";
        } catch (Exception e) {
            mensajewall = "swal(\"Encuesta No Creada!\", \"Selecciona 'Ok' para continuar!\", \"error\");";
        }
        PrimeFaces.current().executeScript(mensajewall);
    }
    
    public void eliminar(Encuesta c) {
        String mensajewall = "";
        try {
            this.encuestaFacadeLocal.remove(c);
            listaEncuestas.remove(c);
            this.encuesta = new Encuesta();
            mensajewall = "swal(\"Respuesta Eliminada Correctamente!\", \"Selecciona 'Ok' para continuar!\", \"success\");";
            listaEncuestas.clear();
            listaEncuestas.addAll(encuestaFacadeLocal.findAll());
        } catch (Exception e) {
            mensajewall = "swal(\"Respues No Eliminada!\", \"No puede ser eliminado ¡selecciona 'Ok' para continuar!\", \"error\");";
        }
        PrimeFaces.current().executeScript(mensajewall);
    }

    public Marcaspc getMarcasPC() {
        return marcasPC;
    }

    public void setMarcasPC(Marcaspc marcasPC) {
        this.marcasPC = marcasPC;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public List<Encuesta> getListaEncuestas() {
        return listaEncuestas;
    }

    public void setListaEncuestas(List<Encuesta> listaEncuestas) {
        this.listaEncuestas = listaEncuestas;
    }
    
    @PostConstruct
    public void init() {
        listaEncuestas.addAll(encuestaFacadeLocal.findAll());
        this.encuesta = new Encuesta();
        this.marcasPC = new Marcaspc();
    }

    public Date getObjDate() {
        return objDate;
    }

    public void setObjDate(Date objDate) {
        this.objDate = objDate;
    }
}
