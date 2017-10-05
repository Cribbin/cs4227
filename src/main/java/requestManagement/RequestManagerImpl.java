package requestManagement;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import requestManagement.fleet.FleetManager;
import requestManagement.loadBalancing.LoadBalancer;

public class RequestManagerImpl implements RequestManager {

    private Context context = null;
    private Dispatcher dispatcher = null;
    private LoadBalancer loadBalancer = null;
    private FleetManager fleetManager = null;

    RequestManagerImpl(RequestManagerBuilder builder) {
        context = builder.getContext();
        dispatcher = builder.getDispatcher();
        loadBalancer = builder.getLoadBalancer();
        fleetManager = builder.getFleetManager();
    }

    @Override
    public HttpResponse handleRequest(HttpRequest request) {

        /* Dispatch incoming request event to all subscribed services. */
        dispatcher.dispatchIncomingRequest(request, context);

        /* Actually forward the request. This is where the Load Balancer would be called.*/

        HttpResponse response = null;

        /* response = loadBalancer.handleRequest(request); */

        /* Dispatch outgoing response to all subscribed services */
        dispatcher.dispatchOutgoingResponse(response, context);

        return response;
    }

    @Override
    public void initialiseFleet() {
        /* Should initialise the fleet here eventually. */
    }
}
