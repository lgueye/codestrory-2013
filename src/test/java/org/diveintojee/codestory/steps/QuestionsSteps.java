package org.diveintojee.codestory.steps;

import com.google.common.collect.ImmutableMap;
import com.sun.jersey.api.client.ClientResponse;
import org.apache.commons.codec.EncoderException;
import org.diveintojee.codestory2013.QuestionsResource;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.util.Map;

/**
 * @author louis.gueye@gmail.com
 */
public class QuestionsSteps extends BackendBaseSteps {

    public QuestionsSteps(Exchange exchange) {
        super(exchange);
    }

    @When("the server is asked the question \"$question\"")
    @Alias("the server is asked for the calculation \"$question\"")
    public void askQuestion(@Named("question") String question) throws EncoderException {
        this.exchange.getRequest().setType("*/*");
        this.exchange.getRequest().setRequestedType(MediaType.TEXT_PLAIN);
        final
        String
                uri =
                UriBuilder.fromResource(QuestionsResource.class).queryParam("q", question)
                        .build().toString();
        this.exchange.getRequest().setUri(uri);
        this.exchange.sendGetRequest();
    }

    @Override
    public Map<String, String> actualRow(ClientResponse clientResponse) {
        ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<String, String>();
        builder.put("code", String.valueOf(clientResponse.getStatus()));
        builder.put("body", String.valueOf(clientResponse.getEntity(String.class)));
        builder.put("requiredType", clientResponse.getHeaders().getFirst("Content-Type"));
        return builder.build();
    }
}
