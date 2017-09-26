/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


import CH03.Services.*;
import CH04.webdav.*;
import CH05.*;
import CH05.conversion.ColorConverterProvider;
import CH06.*;
import CH06.JAXB.*;
import CH07.*;
import java.util.Arrays;
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
        singletons.add(new DefaultValueImpl());
        singletons.add(new CustomerResource_XMLCustom());
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        empty = new HashSet<> (Arrays.asList(
                        CustomerResource.class, 
                        OrderResource.class, 
                        CustomerResourceTemplates.class, 
                        CustomerDatabaseResource.class, 
                        FirstLastCustomerResource.class, 
                        Resource1.class, 
                        Resource2.class, 
                        PathParamImpl.class, 
                        PathSegmentImpl.class, 
                        MatrixParamImpl.class, 
                        QueryParamImpl.class, 
                        FormParamImpl.class, 
                        HeaderParamImpl.class, 
                        CookieParamImpl.class, 
                        BeanParamImpl.class, 
                        ColorConverterProvider.class, 
                        EncodedImpl.class,
                        StreamingOutputImpl.class,
                        InputStreamImpl.class,
                        FileImpl.class,
                        ByteImpl.class,
                        MultivaluedMapImpl.class,
                        TransformXML.class,
                        CustomerResourceXML.class,
                        CustomerResourceJSON.class,
                        TextBookService.class,
                        ReturnCookie.class,
                        WebException.class
                ));
        return empty;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
    
    
    
}
