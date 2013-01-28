package org.diveintojee.codestory2013.steps;

import com.google.common.base.Strings;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.client.apache4.ApacheHttpClient4;
import com.sun.jersey.client.apache4.config.DefaultApacheHttpClient4Config;

import org.junit.Assert;

import java.net.URI;
import java.util.ResourceBundle;


/**
 * User: louis.gueye@gmail.com Date: 24/08/12 Time: 01:14
 */
public class Exchange {

  private static final
  String
      baseEndPoint =
      ResourceBundle.getBundle("stories-context").getString("baseEndPoint");

  /**
   *
   */
  public Exchange() {
    this.request = new Request();
    final DefaultClientConfig config = new DefaultApacheHttpClient4Config();
    this.jerseyClient = ApacheHttpClient4.create(config);
    this.jerseyClient.addFilter(new LoggingFilter());
    config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
  }

  private final Request request;
  private final Client jerseyClient;
  private ClientResponse clientResponse;

  /**
   * @param expected
   */
  public void assertExpectedStatus(int expected) {
    Assert.assertEquals(expected, this.clientResponse.getStatus());
  }

  /**
   * @return
   */
  public void sendGetRequest() {
    final URI uri = newURI(this.request.getUri());
    this.clientResponse = this.jerseyClient.resource(uri).type(this.request.getType())
        .accept(this.request.getRequestedType()).get(ClientResponse.class);
  }

  /**
   * @return
   */
  public void sendPostRequest() {
    final URI uri = newURI(this.request.getUri());
    this.clientResponse = this.jerseyClient
        .resource(uri)
        .type(this.request.getType())
        .post(ClientResponse.class, this.request.getBody());
  }

  /**
   * @param uriAsString
   * @return
   */
  private URI newURI(String uriAsString) {
    if (Strings.isNullOrEmpty(uriAsString)) {
      return URI.create(baseEndPoint);
    }
    if (!uriAsString.startsWith("/")) {
      return URI.create(uriAsString);
    }
    return URI.create(baseEndPoint + uriAsString);
  }

  /**
   * @return
   */
  public Request getRequest() {
    return this.request;
  }

  public ClientResponse getClientResponse() {
    return clientResponse;
  }
}
