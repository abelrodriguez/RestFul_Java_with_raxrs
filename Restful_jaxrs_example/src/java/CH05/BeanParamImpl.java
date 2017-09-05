/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH05;

import java.net.URI;
import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/beanparamimpl")
public class BeanParamImpl {
    
    @POST
    public Response createCustomer(@BeanParam CustomerInput newCust) {
        System.out.println(newCust.toString());
        
        return javax.ws.rs.core.Response.created(URI.create("/beanparamimpl/1")).build();

    }
}
