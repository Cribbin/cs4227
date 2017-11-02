package integ;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requests.HttpRequest;
import responses.HttpResponse;
import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.hosts.Host;
import requestManagement.loadBalancer.LbClientSideRandom;
import requestManagement.loadBalancer.LoadBalancer;

import java.io.IOException;

/**
 * Testing for load balancer request dispatch. Uses the httpbin.org website for testing requests/responses.
 */
class HttpRequests {

    private LoadBalancer loadBalancer;
    
    @BeforeEach
    void setUp() {
        FleetManager fleetManager = FleetManager.getInstance();
        Host testHost = new Host.HostBuilder("192.168.1.1")
                .withDns("httpbin.org")
                .withState("active")
                .build();

        fleetManager.addHost(testHost);

        loadBalancer = LoadBalancer.getBuilder()
                .withFleetManager(fleetManager)
                .withLoadBalancingStrategy(new LbClientSideRandom(fleetManager))
                .build();

    }

    @Test
    void shouldReturn200Success() throws IOException {
        HttpResponse response = null;

        HttpRequest request = HttpRequest.getBuilder()
                .withUri("https://my-random-example-middleware-host.com/get")
                .withMethod("GET")
                .build();

        response = loadBalancer.executeRequest(request);

        assert response.getStatus().equals("OK");
        assert response.getStatusCode() == 200;
    }

    @Test
    void shouldContainCorrectJsonResponseMappedFromQueryString() throws JSONException {
        HttpResponse response = null;

        HttpRequest request = HttpRequest.getBuilder()
                .withUri("https://my-other-super-random-example-middleware-host.com/get?sample_arg=1")
                .withMethod("GET")
                .build();

        try {
            response = loadBalancer.executeRequest(request);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        assert response.getBody().getJSONObject("args").getInt("sample_arg") == 1;
    }
}