/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH06;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/ByteImpl")
public class ByteImpl {
    
    @GET
    @Produces("text/plain")
    public byte[] get() {
        return "hello world".getBytes();
    }
    
    //http://localhost:8080/Restful_jaxrs_example/services/ByteImpl
    @POST
    @Consumes("text/plain")
    public void post(byte[] bytes) {
        System.out.println(new String(bytes));
    }
}
