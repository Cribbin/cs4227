package responses;

import org.json.JSONObject;

import java.util.Map;

public class HttpResponse {

    private Map<String, String> headers;
    private JSONObject body;
    private String status;
    private int statusCode;

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setBody(JSONObject body) {
        this.body = body;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public JSONObject getBody() {
        return this.body;
    }

    public String getStatus() {
        return this.status;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
