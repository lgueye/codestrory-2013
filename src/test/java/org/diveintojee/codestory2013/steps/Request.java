package org.diveintojee.codestory2013.steps;

import javax.ws.rs.core.MediaType;

/**
 * @author louis.gueye@gmail.com
 */
public class Request {

    private String uri;
    private Object body;
    private String requestedType = MediaType.APPLICATION_JSON;
    private String type = MediaType.APPLICATION_JSON;

    public String getRequestedType() {
        return this.requestedType;
    }

    public String getUri() {
        return this.uri;
    }

    public String getType() {
        return this.type;
    }

    public Object getBody() {
        return this.body;
    }

    public void setRequestedType(String requestedType) {
        this.requestedType = requestedType;
    }

    public void setType(String type) {

        this.type = type;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
