/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DTO.Customer;
import DTO.ICustomerResource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Abel Rodríguez
 */

public class CustomerResource implements ICustomerResource{
    private Map<Integer , Customer> customerDB = new ConcurrentHashMap<Integer, Customer>();
    private AtomicInteger idCounter = new AtomicInteger();
    
    // POST http://localhost:8080/Restful_jaxrs_example/services/customers
    @Override
    public Response createConsumer(InputStream is) {
        Customer customer = readCustomer(is);
        customer.setId(idCounter.incrementAndGet());
        customerDB.put(customer.getId(), customer);
        System.out.println("Created customer " + customer.getId());
        return javax.ws.rs.core.Response.created(URI.create("/customers/" + customer.getId())).build();
    }
    
    // GET http://localhost:8080/Restful_jaxrs_example/services/customers/1
    @Override
    public StreamingOutput getCostumer(int id) {
        final Customer customer = customerDB.get(id);
        
        
        if (customer == null) {
            throw new WebApplicationException(javax.ws.rs.core.Response.Status.NOT_FOUND);
        }
        
        //Nota: no se suele usar StreamingOutput en los responses. Ver Capitulo 6 del libro, existe un metodo que convierte objetos Java en XML
        return new StreamingOutput() {
            public void write(OutputStream outputStream) throws IOException, WebApplicationException {
                outputCustomer(outputStream, customer);
            }
                    
        };
    }

    // PUT http://localhost:8080/Restful_jaxrs_example/services/customers/1
    @Override
    public void updateCustomer(int id, InputStream is) {
        Customer update = readCustomer(is);
        Customer current = customerDB.get(id);
        if (current == null) {
            throw new WebApplicationException(javax.ws.rs.core.Response.Status.NOT_FOUND);
        }
        
        current.setFirstName(update.getFirstName());
        current.setLastName(update.getLastName());
        current.setStreet(update.getStreet());
        current.setState(update.getState());
        current.setZip(update.getZip());
        current.setCountry(update.getCountry());
    }
    
    
    protected Customer readCustomer(InputStream is) {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(is);
            Element root = doc.getDocumentElement();
            
            
            Customer cust = new Customer();
            if (root.getAttribute("id") != null && !root.getAttribute("id").trim().equals("")) {
                cust.setId(Integer.valueOf(root.getAttribute("id")));
            }
            NodeList nodes = root.getChildNodes();
            for (int i=0; i < nodes.getLength(); i++) {
                //Element element = (Element) nodes.item(i);
                Node node = nodes.item(i);
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                
                    switch(element.getTagName()){
                        case "first-name":
                            cust.setFirstName(element.getTextContent());
                            break;
                        case "last-name":
                            cust.setLastName(element.getTextContent());
                            break;
                        case "street":
                            cust.setStreet(element.getTextContent());
                            break;
                        case "city":
                            cust.setCity(element.getTextContent());
                            break;
                        case "state":
                            cust.setState(element.getTextContent());
                            break;
                        case "zip":
                            cust.setZip(element.getTextContent());
                            break;
                        case "country":
                            cust.setCountry(element.getTextContent());
                            break;
                    }
                }
            }
            return cust;
            
        } catch (Exception e) {
            System.out.println("EXCEPCION");
            System.out.println(e.getMessage());
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
    }
    
    protected void outputCustomer(OutputStream os, Customer cust) throws IOException {
        PrintStream writer = new PrintStream(os);
        
        writer.println("<customer id=\"" + cust.getId() + "\">");
        writer.println("    <first-name>" + cust.getFirstName()+ "</first-name>");
        writer.println("    <last-name>" + cust.getLastName()+ "</last-name>");
        writer.println("    <street>" + cust.getStreet()+ "</street>");
        writer.println("    <city>" + cust.getCity()+ "</city>");
        writer.println("    <state>" + cust.getState()+ "</state>");
        writer.println("    <zip>" + cust.getZip()+ "</zip>");
        writer.println("    <country>" + cust.getCountry()+ "</country>");
        writer.println("</customer>");
    
    }
}
