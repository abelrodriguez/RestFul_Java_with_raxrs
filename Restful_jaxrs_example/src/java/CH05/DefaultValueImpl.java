/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH05;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/defaultvalueimpl")
public class DefaultValueImpl  {

    //http://localhost:8080/Restful_jaxrs_example/services/defaultvalueimpl/?start=12&size=5
    @GET
    public String getCustomers(@DefaultValue("1") @QueryParam("start") int start,
                               @DefaultValue("10") @QueryParam("size") int size) {
        
        String cadena = "Start:" + start + "|size:" + size;
        
        return cadena;
    }
    
}
