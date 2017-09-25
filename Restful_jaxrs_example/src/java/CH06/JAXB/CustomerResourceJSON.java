/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH06.JAXB;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.OutputStream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/customersJSON")
public class CustomerResourceJSON {
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StreamingOutput getCustomer(@PathParam("id") int id) {
        CustomerJSON cust = new CustomerJSON();
        AddressXML address = new AddressXML();
        
        cust.setId(1);
        cust.setFullname("Abel Rodríguez");
        
        address.setCity("Madrid");
        address.setState("Spain");
        address.setStreet("Avenida");
        address.setZip("28080");
        
        cust.setAddress(address);
        
        ObjectMapper mapper = new ObjectMapper();
        
        return new StreamingOutput() {
            @Override
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                mapper.writeValue(outputStream, cust);
            }
                    
        };
        
 
    }
}
