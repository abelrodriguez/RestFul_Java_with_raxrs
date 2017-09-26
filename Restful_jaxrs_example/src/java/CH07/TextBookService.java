/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH07;

import java.util.Locale;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/textbook")
public class TextBookService {
    @GET
    @Path("/restfuljava")
    @Produces("text/plain")
    public Response getBook() {
        String book = "Jax-RS 2.0";
        
        ResponseBuilder builder = Response.ok(book);
        builder.language(Locale.ENGLISH)
                .header("Header", "value");
        
        return builder.build();        
    }
}
