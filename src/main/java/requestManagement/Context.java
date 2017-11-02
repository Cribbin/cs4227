package requestManagement;

import responses.HttpResponse;

/**
 * This class encapsulates events that are dispatched to interceptor services..
 *
 * Right now we only have incoming request and outgoing response events. If at a later date we implement support for
 * more complicated events then we can abstract those events within their own objects - this context object will still
 * work.
 */
public class Context <T> {

    private T event;
    private HttpResponse response = null;

    public void setEvent(T event) {
        this.event = event;
    }

    public T getEvent() {
        return event;
    }

    /** Used if a subscribed service has any reason to override the response that would normally be return to the client. */
    public void setResponse(HttpResponse response) {
        this.response = response;
    }

    public HttpResponse getResponse() {
        return response;
    }
    /* TODO: Will eventually be other methods here to allow sharing of *standard* information between interceptor services and control framework. */

}
