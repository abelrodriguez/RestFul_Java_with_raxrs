/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH04.webdav;

import CH03.DTO.Customer;
import CH03.Services.CustomerResource;
import java.util.Map;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/customersDatabase")
public class CustomerDatabaseResource {
    
    protected CustomerResource europe = new CustomerResource();
    protected CustomerResource nortAmerica = new CustomerResource();
    
    @Path("{database}-db")
    public CustomerResource getDatabase(@PathParam("database") String db) {
        //CustomerResource resource = locateCustomerResource(db);
        return locateCustomerResource(db);
    }
    
    protected CustomerResource locateCustomerResource(String db) {
        
        if (db.equals("europe") ) {
            return europe;
        } else {
            return nortAmerica;
        }
    }
}
