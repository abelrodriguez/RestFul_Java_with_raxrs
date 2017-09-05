/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH05;

import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Abel Rodríguez
 */
@Path("encodedimpl")
public class EncodedImpl {
    
    
    /*
    %24 en hexadecimal corresponde con el signo dolar ($)
    Para esta URL:
    http://localhost:8080/Restful_jaxrs_example/services/encodedimpl/?something=%24algo
    
    Con la anotacion @Encoded, la función devuelve "%24algo"
    Sin la anotacion @Encoded, la función devuelve "$algo"
    
    
    */
    @GET
    public String get(@Encoded @QueryParam("something") String str) {
        return str;
    }
}
