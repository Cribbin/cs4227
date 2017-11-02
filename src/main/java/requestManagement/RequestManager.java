package requestManagement;

import responses.HttpResponse;
import requests.HttpRequest;

/**
 * Handles a HttpRequest.
 *
 * An implementation of this class will handle LoadBalancing of requests across a preconfigured fleet. It will also
 * handle Fleet Management from an end user perspective.
 */
public interface RequestManager {

    /** Handles execution of HTTP Request against a host in the configured fleet. */
    HttpResponse handleRequest(HttpRequest request);

    /** Initialise the fleet that the requests will be sent to */
    void initialiseFleet();

    static RequestManagerBuilder getBuilder() {
        return new RequestManagerBuilder();
    }
}
