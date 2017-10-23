package requestManagement.loadBalancer;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import requestManagement.fleetManager.FleetManager;
import requests.ExecutableRequestFactory;
import requests.HttpRequest;
import responses.HttpResponse;
import responses.ResponseFactory;

import java.io.IOException;

public class LoadBalancerImpl implements LoadBalancer {
    private LbStrategy loadBalancingStrategy;
    private FleetManager fleetManager;

    private CloseableHttpClient httpclient = HttpClients.createDefault();
    private ExecutableRequestFactory requestFactory = new ExecutableRequestFactory();
    private ResponseFactory responseFactory = new ResponseFactory();

    LoadBalancerImpl(LoadBalancerBuilder builder) {
        loadBalancingStrategy = builder.getLoadBalancingStrategy();
        fleetManager = builder.getFleetManager();
    }

    @Override
    public HttpResponse executeRequest(HttpRequest request) {
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(
                    requestFactory.getExecutableRequest(request, loadBalancingStrategy.getNextHost()));
        } catch(IOException ex) {
            // TODO: Log this error
            System.err.println(ex.getMessage());
        }

        return responseFactory.generateResponse(response);
    }

    public LbStrategy getLoadBalancingStrategy() {
        return loadBalancingStrategy;
    }

    public FleetManager getFleetManager() {
        return fleetManager;
    }
}
