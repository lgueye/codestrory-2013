package org.diveintojee.codestory2013.jajascript;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

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
        Collection<String> transformed = Collections2.transform(solution.getRents(), new Function<Rent, String>() {
            @Override
            public String apply(Rent input) {
                return input.getName();
            }
        });
        solution.setPath(Lists.newArrayList(transformed));
        return Response.ok().entity(solution).build();
    }

}
