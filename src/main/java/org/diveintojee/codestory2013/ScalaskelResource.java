package org.diveintojee.codestory2013;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

/**
 * @author louis.gueye@gmail.com
 */
@Component
@Path("/scalaskel")
public class ScalaskelResource {

    @Autowired
    private ScalaskelService scalaskelService;

    @Path("/eononce/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getChange(@PathParam("id") String id) {
        final Response.ResponseBuilder ok = Response.ok();
        Map<Integer, List<Map<String,Integer>>> result = scalaskelService.getChange(Integer.valueOf(id));
        ok.entity(result);
        return ok.build();
    }
}
