package requestManagement;

import requests.HttpRequest;
import responses.HttpResponse;
import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.healthCheck.HealthCheck;
import requestManagement.fleetManager.healthCheck.HealthCheckPingingStrategy;
import requestManagement.loadBalancer.LoadBalancer;

import java.io.IOException;

public class RequestManagerImpl implements RequestManager {

    private Dispatcher dispatcher = null;
    private LoadBalancer loadBalancer = null;
    private FleetManager fleetManager = null;
    private HealthCheck healthCheck = null;

    RequestManagerImpl(RequestManagerBuilder builder) {
        dispatcher = builder.getDispatcher();
        loadBalancer = builder.getLoadBalancer();
        fleetManager = builder.getFleetManager();
        healthCheck = builder.getHealthCheck();
    }

    @Override
    public HttpResponse handleRequest(HttpRequest request) {
        HttpResponse response = null;

        Context<HttpRequest> requestContext = new Context<>();
        requestContext.setEvent(request);
        dispatcher.dispatchIncomingRequest(requestContext);

        if (requestContext.getResponse() != null) {
            return requestContext.getResponse();
        }

        try {
            response = loadBalancer.executeRequest(request);
        } catch(IOException ex) {
            ex.printStackTrace();
        }

        Context<HttpResponse> responseContext = new Context<>();
        responseContext.setEvent(response);

        dispatcher.dispatchOutgoingResponse(responseContext);

        if (responseContext.getResponse() != null) {
            return responseContext.getResponse();
        }

        return response;
    }

    @Override
    public void initialiseFleet() {
        /* Should initialise the fleet here eventually. */
        long refreshInterval = 5000L;
        healthCheck.execute(new HealthCheckPingingStrategy(), refreshInterval);
    }
}
