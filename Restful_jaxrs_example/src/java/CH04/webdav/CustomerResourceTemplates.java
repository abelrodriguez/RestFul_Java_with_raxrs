/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH04.webdav;

import CH03.Services.CustomerResource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/")
public class CustomerResourceTemplates  {
    
    
    //http://localhost:8080/Restful_jaxrs_example/services/customers2/abel-rodriguez
    @GET
    @Path("customers2/{firstname}-{lastname}")
    public String getCustomer(@PathParam("firstname") String first,
                              @PathParam("lastname") String last) {
        
        return "dame el cliente con nombre " + first + " y apellidos " + last;
    }
    
    
    // Path con expresiones regulares: Solo se permiten dígitos
    @GET
    @Path("customers2/{id : \\d+}")
    public String getCustomer(@PathParam("id") String id) {
        return "dame cliente con id " + id;
    }
    
    // Path con expresiones regulares: Cualquier cadena de caracteres despues de /customers3
    // Ej: http://localhost:8080/Restful_jaxrs_example/services/customers3/1/abel/prueba/de/cualquier/cadena
    @GET
    @Path("customers3/{id : .+}")
    public String getCustomerAll(@PathParam("id") String id) {
        return "dame cliente con id " + id;
    }
    
    // Path con expresiones regulares: cualquier cadena de caracteres despues de /customers3 y que finalice con /address
    // Ej: http://localhost:8080/Restful_jaxrs_example/services/customers3/1/abel/address
    @GET
    @Path("customers3/{id : .+}/address")
    public String getAddress(@PathParam("id") String id) {
        return "dame dirección del cliente id " + id;
    }
}
