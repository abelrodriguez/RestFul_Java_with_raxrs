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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Abel Rodríguez
 */
@Path("/cars_pathsegment/{make}")
public class PathSegmentImpl {
    
    //http://localhost:8080/Restful_jaxrs_example/services/cars_pathsegment/mercedes/a5;color=amarillo/2005
    @GET
    @Path("/{model}/{year}")
    @Produces("text/html")
    public String getPicture(@Context UriInfo info) {
        
        String make = info.getPathParameters().getFirst("make");
        PathSegment model = info.getPathSegments().get(2);
        
        String carModelo = info.getPathSegments().get(2).toString();
        String carColor = model.getMatrixParameters().getFirst("color");
        String year = info.getPathSegments().get(3).toString();
        
        return "marca:" + make + "<br>" +
                "modelo: " + carModelo + "<br>" +
                "año: " + year + "<br>" +
                "color: " + carColor;
    }
    
}
