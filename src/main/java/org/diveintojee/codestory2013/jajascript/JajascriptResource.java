package org.diveintojee.codestory2013.jajascript;

import com.google.common.collect.Lists;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author louis.gueye@gmail.com
 */
@Path("/jajascript")
@Component
public class JajascriptResource {

    @Autowired
    private JajascriptService jajascriptService;

    @Autowired
    private PropertyNamingStrategy uppercasePropertyNamingStrategy;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/optimize")
    public Response optimizePayload(String body) throws IOException {
        System.out.println(body);
        Rent[] rents = new ObjectMapper().setPropertyNamingStrategy(uppercasePropertyNamingStrategy).readValue(body, Rent[].class);
        Plan solution = jajascriptService.optimize(Lists.newArrayList(rents), new HashMap<Rent, Plan>());
        return Response.ok().entity(solution).build();
    }

}
