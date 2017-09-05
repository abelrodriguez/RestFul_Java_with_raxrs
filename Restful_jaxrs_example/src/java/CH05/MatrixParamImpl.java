/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH05;

import CH05.conversion.Color;
import CH05.conversion.ColorConverter;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/cars_matrixparam/{make}")
public class MatrixParamImpl {
    
    //http://localhost:8080/Restful_jaxrs_example/services/cars_matrixparam/mercedes/2005/a5;color=REd (OJO: color es casesensitive)
    @GET
    @Path("/{year}/{model}")
    @Produces("text/html")
    public String getPicture(@PathParam("make") String make,
                             @PathParam("model") String carModelo,
                             @MatrixParam("color") Color carColor,
                             @PathParam("year") String year) {
        
        
        return "marca:" + make + "<br>" +
                "modelo: " + carModelo + "<br>" +
                "año: " + year + "<br>" +
                "color: " + carColor;
    
    }
    
}
