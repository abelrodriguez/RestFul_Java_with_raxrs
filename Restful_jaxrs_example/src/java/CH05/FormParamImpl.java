/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH05;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


/**
 *
 * @author Abel Rodríguez
 */
@Path("/customers_formparam")
public class FormParamImpl {
    
    @POST
    public String createCustomer(@FormParam("firstname") String first,
                                @FormParam("lastname") String last) {
        
        return "cliente creado: " + first + " " + last;
    }
}
