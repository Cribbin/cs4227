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

        if(requestUrl != null && requestUri == null){
            finalUri += requestUrl.toString();
        } else if(requestUrl != null && requestUri != null){
            finalUri += requestUrl.append('?').append(requestUri).toString();
        }
        return finalUri;
    }
}
