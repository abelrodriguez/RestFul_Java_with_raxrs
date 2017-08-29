/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH04.webdav;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/orders")
public class OrderResource {
    
    @GET
    public String getAllOrders() {
        return "todos los pedidos...";
    }
    
    @GET
    @Path("unpaid")
    public String getUnpaidOrders() {
        return "pedidos impagados...";
    }
}
