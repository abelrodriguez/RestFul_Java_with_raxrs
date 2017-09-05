/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH05;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/customers_queryparam")
public class QueryParamImpl {
    
    //http://localhost:8080/Restful_jaxrs_example/services/customers_queryparam?start=10&size=5&orderby=last&orderby=first
    @GET
    @Produces("application/xml")
    public String getCustomers(@QueryParam("start") int start,
                               @QueryParam("size") int size,
                               @Context UriInfo info,
                               @QueryParam("orderby") List<String> orderBy) {
        
        String resultado = "empieza en " + start + " y tamaño " + size;
        resultado += "\r\nEste es otro modo: " + info.getQueryParameters().getFirst("start") + " y " + info.getQueryParameters().getFirst("size");
        
        resultado += "\r\nListado de orderBy:";
        
        for (String order : orderBy) {
            resultado += "\r\n" + order;
        }
        return resultado;
    }
}
