package requestManagement;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import requestManagement.fleetManager.FleetManager;
import requestManagement.loadBalancing.LoadBalancer;

public class RequestManagerImpl implements RequestManager {

    private Dispatcher dispatcher = null;
    private LoadBalancer loadBalancer = null;
    private FleetManager fleetManager = null;

    RequestManagerImpl(RequestManagerBuilder builder) {
        dispatcher = builder.getDispatcher();
        loadBalancer = builder.getLoadBalancer();
        fleetManager = builder.getFleetManager();
    }

    @Override
    public HttpResponse handleRequest(HttpRequest request) {

        /* Dispatch incoming request event to all subscribed services. */

        Context<HttpRequest> requestContext = new Context<>();
        requestContext.setEvent(request);
        dispatcher.dispatchIncomingRequest(requestContext);

        /* Actually forward the request. This is where the Load Balancer would be called.*/

        HttpResponse response = null;

        /* response = loadBalancer.handleRequest(request); */

        Context<HttpResponse> responseContext = new Context<>();
        responseContext.setEvent(response);
        /* Dispatch outgoing response to all subscribed services */
        dispatcher.dispatchOutgoingResponse(responseContext);

        return response;
    }

    @Override
    public void initialiseFleet() {
        /* Should initialise the fleet here eventually. */
    }
}
