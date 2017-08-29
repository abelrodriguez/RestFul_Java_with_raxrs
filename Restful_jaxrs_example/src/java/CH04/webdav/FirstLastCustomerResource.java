/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH04.webdav;

import CH03.DTO.Customer;
import CH03.Services.CustomerResource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/customersName")
public class FirstLastCustomerResource extends CustomerResource {
    
    private Map<String, Customer> customerDB2 = new ConcurrentHashMap<>();
    
    @POST
    @Consumes("application/xml")
    @Override
    public Response createConsumer(InputStream is) {
        Customer customer = readCustomer(is);
        customerDB2.put(customer.getFirstName() + "-" + customer.getLastName(), customer);
        System.out.println("Created customer " + customer.getFirstName() + "-" + customer.getLastName());
        return javax.ws.rs.core.Response.created(URI.create("/Restful_jaxrs_example/services/customersName/" + customer.getFirstName() + "-" + customer.getLastName())).build();
    }
    
    @GET
    @Path("{first}-{last}")
    @Produces("application/xml")
    public StreamingOutput getCustomer(@PathParam("first") String firstName,
                                       @PathParam("last") String lastName) {
        final Customer customer = customerDB2.get(firstName + "-" + lastName);
        
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
    
    
    @PUT
    @Path("{first}-{last}")
    @Consumes("application/xml")
    public void updateCustomer(@PathParam("first") String firstName,
                               @PathParam("last") String lastName,
                               InputStream is) {
        
        Customer update = readCustomer(is);
        Customer current = customerDB2.get(firstName + "|" + lastName);
        if (current == null) {
            throw new WebApplicationException(javax.ws.rs.core.Response.Status.NOT_FOUND);
        }
        
        current.setFirstName(update.getFirstName());
        current.setLastName(update.getLastName());
        current.setStreet(update.getStreet());
        current.setState(update.getState());
        current.setZip(update.getZip());
        current.setCountry(update.getCountry());
    }
     
}
