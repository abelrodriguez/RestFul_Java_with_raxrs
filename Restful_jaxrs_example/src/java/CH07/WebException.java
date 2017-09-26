/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH07;

import CH03.DTO.Customer;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/webexception")
public class WebException {
    
    @GET
    @Path("{id}")
    @Produces("application/xml")
    public Customer getCustomer(@PathParam("id") int id) {
        
        Customer cust = null;
        
        if (cust == null) {
            // OPCION 1
            //throw new WebApplicationException(Response.Status.NOT_FOUND);
            
            // OPCION 2
            throw new NotFoundException();
        }
        
        return cust;
    }
}
