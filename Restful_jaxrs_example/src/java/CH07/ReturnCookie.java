/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH07;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 *
 * @author Abel Rodríguez
 */
@Path("returnCookie")
public class ReturnCookie {
    
    @GET
    public Response get() {
        NewCookie cookie = new NewCookie("key", "value");
        ResponseBuilder builder = Response.ok("hello", "text/plain");
        
        return builder.cookie(cookie).build();
    }
}

