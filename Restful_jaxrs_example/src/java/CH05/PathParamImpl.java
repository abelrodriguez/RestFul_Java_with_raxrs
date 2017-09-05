/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH05;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/cars_pathparam/{make}")
public class PathParamImpl {
    
    //http://localhost:8080/Restful_jaxrs_example/services/cars_pathparam/mercedes/a5;color=amarillo/2005
    @GET
    @Path("/{model}/{year}")
    @Produces("text/html")
    public String getPicture(@PathParam("make") String make,
                             @PathParam("model") PathSegment car,
                             @PathParam("year") String year) {
        
        String carModelo = car.toString();
        String carColor = car.getMatrixParameters().getFirst("color");
        
        return "marca:" + make + "<br>" +
                "modelo: " + carModelo + "<br>" +
                "año: " + year + "<br>" +
                "color: " + carColor;
    }
    
}
