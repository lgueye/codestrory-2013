package org.diveintojee.codestory2013.jajascript;

import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.springframework.stereotype.Component;

/**
 * @author louis.gueye@gmail.com
 */
@Component
public class UppercasePropertyNamingStrategy extends PropertyNamingStrategy.PropertyNamingStrategyBase {
    @Override
    public String translate(String defaultName) {
        return defaultName.toUpperCase();
    }

}
