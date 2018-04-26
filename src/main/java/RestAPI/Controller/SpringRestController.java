package RestAPI.Controller;

import RestAPI.Entidades.Directorio;
import RestAPI.Entidades.EchoString;

import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.GsonBuilder;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author natalie.dibono
 */
@RestController /*identifica a la clase como Controlador*/
public class SpringRestController {
    
    /*AtomicLong es un tipo de dato long que tiene la capacidad de actualizarse automáticamente*/
    private final AtomicLong counter = new AtomicLong();
    
    /****************************************************************/
    /******************REQUEST A ************************************/
    /****************************************************************/
    
    /*REQUEST a "localhost:8080/" - Muestra un mensaje*/
    
    @RequestMapping("/") /*@RequestMapping asegura que las solicitudes HTTP a "/" se mapean al metodo welcome().*/
    public String welcome() {
        return "Hola! estás en http://localhost:8080/";
    }
    
    /****************************************************************/
    /*************REQUEST API ECHO***********************************/
    /****************************************************************/
    
    /*REQUEST ECHO a "localhost:8080/lo que sea" - Muestra lo ingresado luego de la "/" en formato json*/
    
    //Aquí @RequestMapping asegura que las solicitudes HTTP a "/algo" se mapean al metodo mensaje().
    @RequestMapping("/{sample}")/*@RequestMapping asegura que las solicitudes HTTP a "/algo" se mapean al metodo mensaje().*/
    
    public EchoString mensaje(@PathVariable String sample) {/*@PathVariable indica que determinado parámetro se vinculará a determinada variable en la URL*/

        EchoString msjEcho = new EchoString(counter.incrementAndGet(), sample);
        return msjEcho;
    }
    
    /****************************************************************/
    /*************REQUEST A LA API DE GOOGLE DRIVE*******************/
    /****************************************************************/
  
    /*REQUEST a "localhost:8080/sendGetToDrive" (API de Google Drive)- URL Pública*/
    
    /*RequestMapping mapea las solicitudes http al metodo getListOfFilesFromDrive*/
    @RequestMapping(value = "/sendGetToDrive", method = RequestMethod.GET, produces = "application/json")

    public String getListOfFilesFromDrive() {
        
        //Template que provee Spring para interactuar de manera sencilla con servicios Rest desde el lado cliente
        RestTemplate restTemplate = new RestTemplate();
        //Metodo de RestTemplate que nos permite acceder directamente a la respuesta y extraer el body entre otros (headers, etc)
        Directorio dir = restTemplate.getForObject("https://www.googleapis.com/drive/v3/files?q="
                                      /*FolderId*/ + "'1xob03jh8nZbHsT4tZF63w_tYR9ZW4mhZ'+in+parents"
                              /*Partial Response*/ + "&fields=files(id,mimeType,name,webContentLink,webViewLink)"
                                        /*APIKey*/ + "&key=AIzaSyDJymYnm4OA2Cf4YBEZhH5_V__vUu10rkY", Directorio.class);
       
        /*IMPRIMIMOS LA INFO EN FORMATO JSON*/
        //Gson nos ayuda a imprimir con formato el JSON en String
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String jsonString = gson.toJson(dir);
        
        //Imprimimos en consola en formato JSON
	System.out.println(jsonString);
        
        //retornamos un String con la data del json
        return jsonString;
    }
    
}
