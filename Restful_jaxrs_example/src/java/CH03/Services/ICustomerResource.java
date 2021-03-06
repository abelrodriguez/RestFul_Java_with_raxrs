/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH03.Services;

import java.io.InputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/customers")
public interface ICustomerResource {
    @POST
    @Consumes("application/xml")
    public Response createConsumer(InputStream is);
    
    @GET
    @Path("{id}")
    @Produces("application/xml")
    public StreamingOutput getCostumer(@PathParam("id") int id);
    
    @PUT
    @Path("{id}")
    @Consumes("application/xml")
    public void updateCustomer(@PathParam("id") int id, InputStream is);
}
