package requestManagement.loadBalancer;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.hosts.Host;
import requests.ExecutableRequestFactory;
import requests.HttpRequest;
import responses.HttpResponse;
import responses.ResponseFactory;

import java.io.IOException;

public class LoadBalancerImpl implements LoadBalancer {
    private LbStrategy loadBalancingStrategy;
    private FleetManager fleetManager;

    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private ExecutableRequestFactory requestFactory = new ExecutableRequestFactory();
    private ResponseFactory responseFactory = new ResponseFactory();

    LoadBalancerImpl(LoadBalancerBuilder builder) {
        loadBalancingStrategy = builder.getLoadBalancingStrategy();
        fleetManager = builder.getFleetManager();
    }

    @Override
    public HttpResponse executeRequest(HttpRequest request) throws IOException {
        CloseableHttpResponse response = null;
        HttpResponse facadeResponse = null;
        // TODO: Increment active connections for chosen host.
        Host chosenHost = loadBalancingStrategy.getNextHost();
        try {
            response = httpClient.execute(
                    requestFactory.getExecutableRequest(request, chosenHost));

            facadeResponse = responseFactory.generateResponse(response);
        } finally {
            httpClient.close();

            // TODO: Decrement active connections for host.
        }
        return facadeResponse;
    }

    public LbStrategy getLoadBalancingStrategy() {
        return loadBalancingStrategy;
    }

    public FleetManager getFleetManager() {
        return fleetManager;
    }
}
