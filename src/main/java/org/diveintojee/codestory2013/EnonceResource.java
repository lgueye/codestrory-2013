package org.diveintojee.codestory2013;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author louis.gueye@gmail.com
 */
@Component
@Path("/enonce")
public class EnonceResource {

    @Path("/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @POST
    public Response readEnonce(@PathParam("id") Long id, String body) {
        final Response.ResponseBuilder ok = Response.ok();
        System.out.println("============================= enonce " + id + " =====================================");
        System.out.println(body);
        return ok.build();
    }
}
