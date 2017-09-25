/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH06.JAXB;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/customersXML")
public class CustomerResourceXML {
    
    @GET
    @Path("/{id}")
    @Produces("application/xml")
    public CustomerXML getCustomer(@PathParam("id") int id) {
        CustomerXML cust = new CustomerXML();
        AddressXML address = new AddressXML();
        
        cust.setId(1);
        cust.setFullname("Abel Rodríguez");
        
        address.setCity("Madrid");
        address.setState("Spain");
        address.setStreet("Avenida");
        address.setZip("28080");
        
        cust.setAddress(address);
        
        return cust;
        
    }
}
