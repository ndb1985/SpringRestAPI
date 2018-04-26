package RestAPI.Entidades;

import RestAPI.Entidades.Archivo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;



@JsonIgnoreProperties(ignoreUnknown = true) 
public class Directorio {
    //@JsonProperty("kind")
    //private String tipo;
    @JsonProperty("files")
    private List<Archivo> listaArchivos;

   
    public Directorio() {
    }

    
    public Directorio(List<Archivo> listaArchivos) {
        this.listaArchivos = listaArchivos;
    }

    public List<Archivo> getArchivos() {
        return listaArchivos;
    }

    public void setArchivos(List<Archivo> contenido) {
        this.listaArchivos = contenido;
    }

       
    @Override
    public String toString() {
        return "Directorio{" + '\'' +
               ", listaArchivos=" + listaArchivos +
                '}';
    }
    
    
    
}
