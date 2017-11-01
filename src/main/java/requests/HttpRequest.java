package requests;

import org.json.JSONObject;

/**
 * Facade object for HTTP Requests used by the Load Balancing framework.
 */
public class HttpRequest {

    private String method;
    private JSONObject json;
    private String uri;

    /**
     * This constructor is protected level access in order to allow adaptor classes that subclass the HttpRequest class
     * to be instantiated using a standard builder.
     *
     * @param builder Object builder.
     */
    protected HttpRequest(HttpRequestBuilder builder) {
        this.method = builder.getMethod();
        this.json = builder.getJson();
        this.uri = builder.getUri();
    }

    public String getMethod() {
        return method;
    }

    public JSONObject getParams() {
        return json;
    }

    public String getUri() {
        return uri;
    }

    /* More members, i.e. Client IP Insertion, Cookie Insertion, etc that would be private and part of the facade. */

    public static HttpRequestBuilder getBuilder() {
        return new HttpRequestBuilder();
    }
}
