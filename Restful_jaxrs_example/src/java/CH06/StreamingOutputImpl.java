/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH06;

import java.io.IOException;
import java.io.OutputStream;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.StreamingOutput;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/StreamingOutputImpl")
public class StreamingOutputImpl {
    
    @GET
    @Produces("text/plain")
    public StreamingOutput get() {
        return new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException {
                output.write("hello world".getBytes());
            }
        };
    }
}
