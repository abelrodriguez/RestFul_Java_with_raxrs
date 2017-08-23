/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


import Services.CustomerResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Abel Rodríguez
 */
@ApplicationPath("/services")
public class ShoppingApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> empty = new HashSet<Class<?>>();
    
    public ShoppingApplication() {
        singletons.add(new CustomerResource());
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        empty.add(CustomerResource.class);
        return empty;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
    
    
    
}
