package org.diveintojee.codestory2013.steps;

import com.sun.jersey.api.client.ClientResponse;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.OutcomesTable;

import java.util.Map;

/**
 * @author louis.gueye@gmail.com
 */
public abstract class BackendBaseSteps {

    protected Exchange exchange;

    protected BackendBaseSteps(Exchange exchange) {
        this.exchange = exchange;
    }

    public Exchange getExchange() {
        return this.exchange;
    }

    @Then("the response code should be \"$statusCode\"")
    public void expectStatusCode(@Named("statusCode") final int statusCode) {
        this.exchange.assertExpectedStatus(statusCode);
    }

    @Given("I accept \"<responseContentType>\" format")
    public void setResponseContentType(@Named("responseContentType") final String requestedType) {
        this.exchange.getRequest().setRequestedType(requestedType);
    }

    @Given("I send \"<requestContentType>\" format")
    public void setRequestContentType(@Named("requestContentType") final String type) {
        this.exchange.getRequest().setType(type);
    }

    protected abstract Map<String, String> actualRow(ClientResponse source);

    @Then("the response should be: $table")
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


}
