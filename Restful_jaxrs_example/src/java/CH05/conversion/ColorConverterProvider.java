/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH05.conversion;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Abel Rodríguez
 */
@Provider
public class ColorConverterProvider implements ParamConverterProvider{
    
    private final ParamConverter converter = new ColorConverter();
    
    
    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType,
                                              Type genericType,
                                              Annotation[] annotations) {
        if (!rawType.equals(Color.class)) return null;
        
        
        return converter;
        
    }
}
