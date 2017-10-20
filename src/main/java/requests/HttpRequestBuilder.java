package requests;

import org.json.JSONObject;

public class HttpRequestBuilder {

    HttpRequestBuilder() { }

    private String method;
    private JSONObject json;
    private String uri;

    public void setMethod(String method) {
        this.method = method;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return this.method;
    }

    public JSONObject getJson() {
        return this.json;
    }

    public String getUri() {
        return this.uri;
    }

    public HttpRequestBuilder withMethod(String method) {
        setMethod(method);
        return this;
    }

    public HttpRequestBuilder withJson(JSONObject json) {
        setJson(json);

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
