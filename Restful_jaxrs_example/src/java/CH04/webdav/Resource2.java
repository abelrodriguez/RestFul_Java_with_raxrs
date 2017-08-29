/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH04.webdav;

import java.net.URI;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/{any : .*}")
public class Resource2 {
    
    @GET
    public Response get() {
        return javax.ws.rs.core.Response.created(URI.create("any")).build();
    }
    
    @OPTIONS
    public Response options() {
        return javax.ws.rs.core.Response.created(URI.create("any-options")).build();
    }
}
