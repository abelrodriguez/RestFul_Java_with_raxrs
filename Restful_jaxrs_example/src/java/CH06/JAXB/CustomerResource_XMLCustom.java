/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH06.JAXB;

import CH03.DTO.Customer;
import CH03.Services.CustomerResource;
import java.io.IOException;
import java.io.OutputStream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.StreamingOutput;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/customers-xmlcustom")
public class CustomerResource_XMLCustom extends CustomerResource { 

    @Override
    @GET
    @Path("{id}")
    @Produces("application/xml-custom")
    public StreamingOutput getCostumer(@PathParam("id") int id) {
        final Customer customer = customerDB.get(id);
        
        if (customer == null) {
            throw new WebApplicationException(javax.ws.rs.core.Response.Status.NOT_FOUND);
        }
        
        //Nota: no se suele usar StreamingOutput en los responses. Ver Capitulo 6 del libro, existe un metodo que convierte objetos Java en XML
        return new StreamingOutput() {
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                outputCustomer(outputStream, customer);
            }
                    
        };
    }
    
    
}
