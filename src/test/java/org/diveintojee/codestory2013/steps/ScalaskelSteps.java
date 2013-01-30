package org.diveintojee.codestory2013.steps;

import com.google.common.collect.ImmutableMap;

import com.sun.jersey.api.client.ClientResponse;

import org.diveintojee.codestory2013.scalaskel.ScalaskelResource;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;

import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 * @author louis.gueye@gmail.com
 */
public class ScalaskelSteps extends BackendBaseSteps {
    public ScalaskelSteps(Exchange exchange) {
        super(exchange);
    }

    @When("the server is asked the scalaskel change for value \"$id\"")
    public void getChange(@Named("id") String id) {
        this.exchange.getRequest().setType("*/*");
        this.exchange.getRequest().setRequestedType(MediaType.APPLICATION_JSON);
        final String uri = UriBuilder.fromResource(ScalaskelResource.class).path("/change").path(id).build().toString();
        this.exchange.getRequest().setUri(uri);
        this.exchange.sendGetRequest();
    }

    @Override
    public Map<String, String> actualRow(ClientResponse clientResponse) {
        ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<String, String>();
        builder.put("code", String.valueOf(clientResponse.getStatus()));
        builder.put("body", String.valueOf(clientResponse.getEntity(String.class)));
        return builder.build();
    }

}
