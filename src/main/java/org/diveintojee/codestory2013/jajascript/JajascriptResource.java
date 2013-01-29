package org.diveintojee.codestory2013.jajascript;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/optimize")
    public Response optimizePayload(Rent[] rents) {
        Plan solution = jajascriptService.optimize(Lists.newArrayList(rents));
        return Response.ok().entity(solution).build();
    }

}
