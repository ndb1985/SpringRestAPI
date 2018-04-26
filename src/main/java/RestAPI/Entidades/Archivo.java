package RestAPI.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;



@JsonIgnoreProperties(ignoreUnknown = true)
public class Archivo {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("mimeType")
    private String tipo_de_archivo;
    @JsonProperty("webContentLink")
    private String link_descarga;
    @JsonProperty("webViewLink")
    private String link_preview;

    public Archivo() {
    }

public Archivo(String id, String nombre, String tipo_de_archivo, String link_preview, String link_descarga) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_de_archivo = tipo_de_archivo;
        this.link_preview = link_preview;
        this.link_descarga = link_descarga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_de_archivo() {
        return tipo_de_archivo;
    }

    public void setTipo_de_archivo(String tipo_de_archivo) {
        this.tipo_de_archivo = tipo_de_archivo;
    }

    public String getLink_preview() {
        return link_preview;
    }

    public void setLink_preview(String link_preview) {
        this.link_preview = link_preview;
    }

    public String getLink_descarga() {
        return link_descarga;
    }

    public void setLink_descarga(String link_descarga) {
        this.link_descarga = link_descarga;
    }

    @Override
    public String toString() {
        return "Archivo{" + 
                "id=" + id + 
                ", nombre=" + nombre + 
                ", tipo_de_archivo=" + tipo_de_archivo + 
                ", link_descarga=" + link_descarga + 
                ", link_preview=" + link_preview + '}';
    }

    
    
    
}