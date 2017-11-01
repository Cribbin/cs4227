package requests.adapters;

import requests.HttpRequest;
import requests.HttpRequestBuilder;

/**
 * An example adaptor for the HttpRequest. Would convert XML request body to JSON request body if actually implemented.
 */
public class RequestXmlAdapter extends HttpRequest {
    RequestXmlAdapter(HttpRequestBuilder builder) {
        super(builder);
    }
}
