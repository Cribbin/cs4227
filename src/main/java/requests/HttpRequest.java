package requests;

import org.json.JSONObject;

/**
 * Interface for HTTP Requests used by the Load Balancing framework.
 */
public class HttpRequest {

    private String method;
    private JSONObject json;
    private String uri;

    HttpRequest(HttpRequestBuilder builder) {
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

    /* More members, i.e. Client IP Insertion, Cookie Insertion, etc.*/

    public static HttpRequestBuilder getBuilder() {
        return new HttpRequestBuilder();
    }
}
