/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH06;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.Reader;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/InputStreamImpl")
public class InputStreamImpl {
    
    //http://localhost:8080/Restful_jaxrs_example/services/InputStreamImpl/stuff
    // Lo que se envía, sale en la consola del server
    @PUT
    @Path("/stuff")
    public void putStuff(InputStream is) throws IOException {
        byte[] bytes = readFromStream(is);
        String input = new String(bytes);
        System.out.println(input);
    }
    
    private byte[] readFromStream(InputStream stream) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        
        byte[] buffer = new byte[1000];
        int wasRead = 0;
        do {
            wasRead = stream.read(buffer);
            if (wasRead > 0) {
                baos.write(buffer, 0, wasRead);
            }
        } while (wasRead > -1);
        
        return baos.toByteArray();
    }
    
    @PUT
    @Path("/morestuff")
    public void putMore( Reader reader) throws IOException {
        LineNumberReader lineReader = new LineNumberReader(reader);
        String line;
        do {
            line = lineReader.readLine();
            if (line != null) System.out.println(line);
        } while (line != null);
        
    }
    
    
}
