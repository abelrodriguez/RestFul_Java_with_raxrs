/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Collections;
import java.util.Set;

/**
 *
 * @author Abel Rodríguez
 */
public abstract class Application {
    
    private static final Set<Object> emptySet = Collections.emptySet();
    
    public abstract Set<Class<?>> getClasses();
    
    public Set<Object> getSingletons() {
        return emptySet;
    }
}
