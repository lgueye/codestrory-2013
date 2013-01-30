package org.diveintojee.codestory2013.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
                frenchFormat(calculatorService.getAnswer(q)) : responsesRepository.getAnswer(q);
        if (response != null) {
            ok.entity(response);
        }
        return ok.build();
    }

    boolean isACalculation(String question) {
        final String operators = "[\\s\\-/\\*]";
        String regex = ".*\\d+" + operators + "\\d+.*|.*\\(\\d+.*|.*\\d+\\).*";
        return Pattern.matches(regex, question);
    }

    String frenchFormat(BigDecimal result) {
        return result.stripTrailingZeros().toPlainString().replaceAll("\\.", ",");
    }

}
