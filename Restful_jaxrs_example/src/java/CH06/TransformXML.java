/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH06;

import java.io.InputStream;
import java.io.StringWriter;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/TransformXML")
public class TransformXML {
    
    @POST
    @Consumes("application/xml")
    @Produces("application/xml")
    public String post(Source source) throws TransformerConfigurationException, TransformerException {
        
        TransformerFactory tFactory = TransformerFactory.newInstance();
        
        InputStream is = getClass().getClassLoader().getResourceAsStream("/CH06/foo.xsl");
        
        Transformer transformer = tFactory.newTransformer(new StreamSource(is));
        
        StringWriter writer = new StringWriter();
        transformer.transform(source, new StreamResult(writer));
        
        return writer.toString();
    }
    
}
