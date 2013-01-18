package org.diveintojee.codestory.steps;

import com.google.common.collect.ImmutableMap;

import com.sun.jersey.api.client.ClientResponse;

import org.apache.commons.codec.EncoderException;
import org.diveintojee.codestory2013.Q1Resource;
import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.OutcomesTable;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

/**
 * User: lgueye Date: 18/01/13 Time: 10:54
 */
public class Q3Steps extends Q1Steps {

  public Q3Steps(Exchange exchange) {
    super(exchange);
  }

}
