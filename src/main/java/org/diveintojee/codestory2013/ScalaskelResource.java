package org.diveintojee.codestory2013;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author louis.gueye@gmail.com
 */
@Component
@Path("/scalaskel")
public class ScalaskelResource {

    @Autowired
    private ScalaskelService scalaskelService;

    @Path("/eonon/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getChange(@PathParam("id") String id) {
        final Response.ResponseBuilder ok = Response.ok();
        List<String> change = scalaskelService.getChange(id);
        ok.entity(change);
        return ok.build();
    }
}
