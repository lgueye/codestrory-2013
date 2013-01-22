package org.diveintojee.codestory2013;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author louis.gueye@gmail.com
 */
@Component
@Path("/")
public class QuestionsResource {

    @Autowired
    private ResponsesRepository responsesRepository;

    @Autowired
    private CalculatorService calculatorService;

    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public Response readQuestion(@QueryParam("q") String q) {
        final Response.ResponseBuilder ok = Response.ok();
        String response = isACalculation(q) ?
                          calculatorService.getAnswer(q) : responsesRepository.getAnswer(q);
        if (response != null) {
            ok.entity(response);
        }
        return ok.build();
    }

    boolean isACalculation(String question) {
        return Pattern.matches("\\d+[\\+/\\*\\-]\\d+", question);
    }

}
