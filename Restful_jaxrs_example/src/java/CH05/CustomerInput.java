/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH05;

import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;

/**
 *
 * @author Abel Rodríguez
 */
public class CustomerInput {
    
    @FormParam("first")
    String FirstName;
    
    @FormParam("last")
    String lastName;
    
    @HeaderParam("Content-Type")
    String contentType;

    
    
    @Override
    public String toString() {
        return this.FirstName + " " + this.lastName + "|" + this.contentType;
    }
    
}
