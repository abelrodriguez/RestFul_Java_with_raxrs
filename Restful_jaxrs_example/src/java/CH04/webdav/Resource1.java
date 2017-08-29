/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH04.webdav;

import java.net.URI;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/a")
public class Resource1 {
    
    @GET
    @Path("/b")
    public Response get() {
        return javax.ws.rs.core.Response.created(URI.create("/a/b")).build();
    }
}
