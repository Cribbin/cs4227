package requests.adapters;

import requests.HttpRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Adapter class to adapt from a HttpServletRequest to a HttpRequest.
 */
public class HttpServletRequestAdapter extends HttpRequest {

    private HttpServletRequest request;

    public HttpServletRequestAdapter(HttpServletRequest request) {
        this.request=request;
    }

    @Override
    public String getMethod() {
        return request.getMethod();
    }

    @Override
    public String getUri() {
        String finalUri = "";

        StringBuffer requestUrl = request.getRequestURL();
        String requestUri = request.getRequestURI();

        if(requestUrl != null) {
            finalUri = requestUrl.toString();
        }
        if(requestUri != null && finalUri.length() != 0) {
            finalUri = finalUri.substring(0,finalUri.length()-1);
            finalUri += requestUri;
        }
        return finalUri;
    }
}
