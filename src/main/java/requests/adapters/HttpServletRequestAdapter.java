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
        return request.getRequestURI();
    }
}
