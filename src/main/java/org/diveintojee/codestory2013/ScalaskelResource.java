package org.diveintojee.codestory2013;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
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

    @Path("/change/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getChange(@PathParam("id") String id) throws IOException {
        final Response.ResponseBuilder ok = Response.ok();
        final Integer amount = Integer.valueOf(id);
        Map<Integer, List<Map<String, Integer>>> result = scalaskelService.getChange(amount);
        ok.entity(result.get(amount).toArray());
        return ok.build();
    }
}
