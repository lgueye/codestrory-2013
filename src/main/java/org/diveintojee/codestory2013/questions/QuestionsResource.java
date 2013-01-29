package org.diveintojee.codestory2013.questions;

import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
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

    /**
     * @author louis.gueye@gmail.com
     */
    @Component
    public static class ResponsesRepository {

        private static ImmutableMap<String, String> repository;

        static {
            repository = new ImmutableMap.Builder<String, String>()
                    .put("Quelle est ton adresse email", "louis.gueye@gmail.com")
                    .put("Es tu heureux de participer(OUI/NON)", "OUI")
                    .put("Es tu abonne a la mailing list(OUI/NON)", "OUI")
                    .put("Es tu pret a recevoir une enonce au format markdown par http post(OUI/NON)", "OUI")
                    .put("Est ce que tu reponds toujours oui(OUI/NON)", "NON")
                    .put("As tu bien recu le premier enonce(OUI/NON)", "OUI")
                    .put("As tu passe une bonne nuit malgre les bugs de l etape precedente(PAS_TOP/BOF/QUELS_BUGS)", "QUELS_BUGS")
                    .build();
        }

        public String getAnswer(String question) {
            return repository.get(question);
        }
    }
}
