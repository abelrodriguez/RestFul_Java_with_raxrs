/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


import CH03.Services.CustomerResource;
import CH04.webdav.CustomerDatabaseResource;
import CH04.webdav.CustomerResourceTemplates;
import CH04.webdav.FirstLastCustomerResource;
import CH04.webdav.OrderResource;
import CH04.webdav.Resource1;
import CH04.webdav.Resource2;
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
        singletons.add(new FirstLastCustomerResource());
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        empty.add(CustomerResource.class);
        empty.add(OrderResource.class);
        empty.add(CustomerResourceTemplates.class);
        empty.add(CustomerDatabaseResource.class);
        empty.add(FirstLastCustomerResource.class);
        empty.add(Resource1.class);
        empty.add(Resource2.class);
        return empty;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
    
    
    
}
