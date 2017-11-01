package responses;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ResponseFactory {

    public HttpResponse generateResponse(CloseableHttpResponse response) {
        HttpResponse facadeResponse = new HttpResponse();
        JSONObject json = null;
        Map<String, String> headers = new HashMap<>();

        facadeResponse.setStatusCode(response.getStatusLine().getStatusCode());
        facadeResponse.setStatus(response.getStatusLine().getReasonPhrase());

        Arrays.asList(response.getAllHeaders()).forEach(h -> headers.put(h.getName(), h.getValue()));
        facadeResponse.setHeaders(headers);

        try {
            json = new JSONObject(EntityUtils.toString(response.getEntity()));

        } catch (IOException | JSONException ex) {
            ex.printStackTrace();
        }

        facadeResponse.setBody(json);
        return facadeResponse;
    }
}
