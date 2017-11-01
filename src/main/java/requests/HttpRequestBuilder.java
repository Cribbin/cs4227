package requests;

import org.json.JSONObject;

public class HttpRequestBuilder {

    HttpRequestBuilder() { }

    private String method;
    private JSONObject body;
    private String uri;

    public void setMethod(String method) {
        this.method = method;
    }

    public void setBody(JSONObject json) {
        this.body = json;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return this.method;
    }

    public JSONObject getBody() {
        return this.body;
    }

    public String getUri() {
        return this.uri;
    }

    public HttpRequestBuilder withMethod(String method) {
        setMethod(method);
        return this;
    }

    public HttpRequestBuilder withJson(JSONObject json) {
        setBody(json);

        return this;
    }

    public HttpRequestBuilder withUri(String uri) {
        setUri(uri);

        return this;
    }

    public HttpRequest build() {
        return new HttpRequest(this);
    }
}
