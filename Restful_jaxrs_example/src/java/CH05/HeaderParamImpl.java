/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH05;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

/**
 *
 * @author Abel Rodríguez
 */
@Path("headerparamimpl")
public class HeaderParamImpl {
    
    @GET
    @Produces("text/html")
    public String get (@HeaderParam("Referer") String referer,
                       @Context HttpHeaders headers) {
        String cadena;
        
        cadena = "Método 1 (parametros):" + referer + "\r\n";
        cadena += "Método 2 (HttpHeaders):" + headers.getRequestHeader("Referer").get(0) + "\r\n\r\n";
        
        cadena += "Bucle con todos los valores de la cabecera:\r\n";
        for (String header : headers.getRequestHeaders().keySet()) {
            cadena += header + ": " + headers.getRequestHeaders().getFirst(header) + "\r\n";
        }
        
        return cadena;
    }
}
