package org.diveintojee.codestory2013.enonce;

import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * @author louis.gueye@gmail.com
 */
@Component
@Path("/enonce")
public class EnonceResource {

    @Path("/{id}")
    @POST
    public Response readEnonce(@PathParam("id") Long id, String body) {
        System.out.println(body);
        final Response.ResponseBuilder ok = Response.ok();
        return ok.entity(body).build();
    }
}
