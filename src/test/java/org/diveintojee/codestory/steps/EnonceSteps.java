package org.diveintojee.codestory.steps;

import com.google.common.collect.ImmutableMap;
import com.sun.jersey.api.client.ClientResponse;
import org.apache.commons.codec.EncoderException;
import org.diveintojee.codestory2013.EnonceResource;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;

import javax.ws.rs.core.UriBuilder;
import java.util.Map;

/**
 * @author louis.gueye@gmail.com
 */
public class EnonceSteps extends BackendBaseSteps {

    public EnonceSteps(Exchange exchange) {
        super(exchange);
    }

    @When("the server is provided with subject \"$body\", id \"$id\" and media type \"$mediaType\"")
    public void askQuestion(@Named("body") String body, @Named("id") Long id, @Named("mediaType") String mediaType) throws EncoderException {
        this.exchange.getRequest().setType(mediaType);
        this.exchange.getRequest().setRequestedType(null);
        this.exchange.getRequest().setBody(body);
        final String uri = UriBuilder.fromResource(EnonceResource.class).path(id.toString()).build().toString();
        this.exchange.getRequest().setUri(uri);
        this.exchange.sendPostRequest();
    }

    @Override
    public Map<String, String> actualRow(ClientResponse clientResponse) {
        ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<String, String>();
        builder.put("code", String.valueOf(clientResponse.getStatus()));
        builder.put("body", String.valueOf(clientResponse.getEntity(String.class)));
        return builder.build();
    }
}
