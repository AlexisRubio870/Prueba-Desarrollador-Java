package Entity;

import Entity.Marcaspc;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-10-21T16:19:15")
@StaticMetamodel(Encuesta.class)
public class Encuesta_ { 

    public static volatile SingularAttribute<Encuesta, Marcaspc> marcaPCEncuesta;
    public static volatile SingularAttribute<Encuesta, Date> fechaRespuestaEncuesta;
    public static volatile SingularAttribute<Encuesta, String> comentariosEncuesta;
    public static volatile SingularAttribute<Encuesta, Integer> idEncuesta;
    public static volatile SingularAttribute<Encuesta, Integer> noDocumentoEncuesta;
    public static volatile SingularAttribute<Encuesta, String> emailEncuesta;

}