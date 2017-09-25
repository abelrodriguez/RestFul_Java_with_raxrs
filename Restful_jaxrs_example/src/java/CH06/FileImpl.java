/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.URL;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/FileImpl")
public class FileImpl {
    
    private static final String basePath = "//CH06//";
    
    @GET
    @Path("{filepath: .*}")
    @Produces("text/plain")
    public InputStream getFile(@PathParam("filepath") String path) throws FileNotFoundException {
        
        URL uri = getClass().getClassLoader().getResource(basePath + path);
        FileInputStream is = new FileInputStream(uri.getPath());
        
        return is;
    }
    
    /*
    @POST
    @Path("/sendfile")
    public void receiveFile(File file) throws IOException {
        Reader reader = new Reader(new FileInputStream(file)) {
            @Override
            public int read(char[] cbuf, int off, int len) throws IOException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void close() throws IOException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        LineNumberReader lineReader = new LineNumberReader(reader);
        String line;
        do {
            line = lineReader.readLine();
            if (line != null) System.out.println(line);
        } while (line != null);
    }*/
}
