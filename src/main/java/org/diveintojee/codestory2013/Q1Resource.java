package org.diveintojee.codestory2013;

import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author louis.gueye@gmail.com
 */
@Component
@Path("/")
public class Q1Resource {

  @Produces(MediaType.TEXT_PLAIN)
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @POST
  public Response readQuestion(@FormParam("q") String q) {
    final Response.ResponseBuilder ok = Response.ok();
    if ("Quelle est ton adresse email".equals(q)) {
      return ok.entity("louis.gueye@gmail.com").build();
    } else {
      return ok.build();
    }
  }
}
