package org.diveintojee.codestory.steps;

import com.google.common.collect.ImmutableMap;

import com.sun.jersey.api.client.ClientResponse;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.diveintojee.codestory2013.Q1Resource;
import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.OutcomesTable;

import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 * @author louis.gueye@gmail.com
 */
public class Q1Steps extends BackendBaseSteps {

  private static final String Q1_URI = UriBuilder.fromResource(Q1Resource.class).build().toString();

  public Q1Steps(Exchange exchange) {
    super(exchange);
  }

  @When("the server is asked the question \"$question\"")
  public void askQuestion(@Named("question") String question) throws EncoderException {
    this.exchange.getRequest().setType(MediaType.APPLICATION_FORM_URLENCODED);
    this.exchange.getRequest().setBody("q=" + new URLCodec().encode(question));
    this.exchange.getRequest().setRequestedType(MediaType.TEXT_PLAIN);
    this.exchange.getRequest().setUri(Q1_URI);
    this.exchange.createEntity();
  }

  @Then("the response code should be: $table")
  public void assertResponse(ExamplesTable table) {
    Map<String, String> actualRow = actualRow(this.exchange.getClientResponse());
    for (int i = 0; i < table.getRowCount(); i++) {
      Map<String, String> expectedRow = table.getRow(i);
      for (String key : expectedRow.keySet()) {
        OutcomesTable outcomes = new OutcomesTable();
        outcomes.addOutcome(key, actualRow.get(key), Matchers.equalTo(expectedRow.get(key)));
        outcomes.verify();
      }

    }
  }

  private Map<String, String> actualRow(ClientResponse clientResponse) {
    ImmutableMap.Builder<String, String> builder = new ImmutableMap.Builder<String, String>();
    builder.put("code", String.valueOf(clientResponse.getStatus()));
    builder.put("body", String.valueOf(clientResponse.getEntity(String.class)));
    builder.put("requiredType", clientResponse.getHeaders().getFirst("Content-Type"));
    return builder.build();
  }
}
