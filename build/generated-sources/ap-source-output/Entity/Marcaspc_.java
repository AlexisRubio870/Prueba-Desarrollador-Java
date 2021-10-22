package Entity;

import Entity.Encuesta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-10-21T16:19:15")
@StaticMetamodel(Marcaspc.class)
public class Marcaspc_ { 

    public static volatile SingularAttribute<Marcaspc, String> nombreMarcaEncuesta;
    public static volatile CollectionAttribute<Marcaspc, Encuesta> encuestaCollection;
    public static volatile SingularAttribute<Marcaspc, Integer> idMarca;

}