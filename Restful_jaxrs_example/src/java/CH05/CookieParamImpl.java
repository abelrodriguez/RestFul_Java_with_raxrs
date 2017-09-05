/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH05;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/cookieparamimpl")
public class CookieParamImpl {
    
    @GET
    @Produces("text/html")
    public String get(@CookieParam("customerId") int custId, @CookieParam("domain") String domain, @CookieParam("customerId") Cookie cookieCustId, @Context HttpHeaders headers) {
        
        String cadena;
        
        cadena = "Cliente Id: " + custId + " en el dominio " + domain;
        
        cadena += "\r\n\r\nOtro modo de obtener datos de las cookies:\r\n";
        cadena += cookieCustId.getName() + ": " + cookieCustId.getValue() + " con dominio " + cookieCustId.getDomain();
        
        
        cadena += "\r\n\r\nAsí obtenemos todas las cookies contenidas en headers:\r\n";
        
        for (String name : headers.getCookies().keySet())
        {
            Cookie cookie = headers.getCookies().get(name);
            cadena += name + "=" + cookie.getValue();
        }
        return cadena;
    }
}
