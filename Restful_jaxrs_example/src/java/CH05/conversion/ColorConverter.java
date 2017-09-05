/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH05.conversion;

import static CH05.conversion.Color.*;
import javax.ws.rs.ext.ParamConverter;

/**
 *
 * @author Abel Rodríguez
 */
public class ColorConverter implements ParamConverter<Color> {

    @Override
    public Color fromString(String value) {
        if (value.equalsIgnoreCase(BLACK.toString())) return BLACK;
        else if (value.equalsIgnoreCase(BLUE.toString())) return BLUE;
        else if (value.equalsIgnoreCase(RED.toString())) return RED;
        else if (value.equalsIgnoreCase(WHITE.toString())) return WHITE;
        else if (value.equalsIgnoreCase(SILVER.toString())) return SILVER;
        throw new IllegalArgumentException("Invalid color: " + value);
    }

    @Override
    public String toString(Color value) {
        return value.toString();
    }
    
}
