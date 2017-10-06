package requestManagement;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

import java.util.Collection;

/**
 * Dispatcher for interception services.
 *
 * This class maintains a list of all active services that have subscribed to listen for events subject to interception.
 * It also handles dispatching the events to all of the subscribed services.
 *
 * Note: Ordered execution of third party defined services is supported by using any ordered collection to store
 * the services (e.g. ArrayList).
 */
public class Dispatcher {
    private Collection<Service> services;

    public Dispatcher(Collection<Service> services) {
        this.services = services;
    }

    /** Register for all dispatched events */
    public void register(Service service) {
        services.add(service);
    }

    /** Deregister service to no longer receive dispatched events. */
    public void deregister(Service service) {
        services.remove(service);
    }

    /** This event is called as soon as the request is received by the framework. */
    public void dispatchIncomingRequest(Context context) {
        services.forEach( s -> s.processIncomingRequest(context));
    }

    /** This event is called prior to the HttpResponse being sent. */
    public void dispatchOutgoingResponse(Context context) {
        services.forEach(s -> s.processOutgoingResponse(context));
    }
}
