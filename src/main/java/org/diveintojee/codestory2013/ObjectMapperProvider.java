package org.diveintojee.codestory2013;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * @author louis.gueye@gmail.com
 */
@Provider
@Component
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

  ObjectMapper mapper;

  public ObjectMapperProvider() {
    mapper = new ObjectMapper();
  }

  @Override
  public ObjectMapper getContext(Class<?> type) {
    return mapper;
  }
}
