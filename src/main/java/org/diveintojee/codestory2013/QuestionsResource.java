package org.diveintojee.codestory2013;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.regex.Pattern;

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
        String regex = "\\d+[\\" +
                Operator.plus +
                Operator.divide + "\\" +
                Operator.multiply + "\\" +
                Operator.minus + "]\\d+";
        
        return Pattern.matches(regex, question);
    }

}
