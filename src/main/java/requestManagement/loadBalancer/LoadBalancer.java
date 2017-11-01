package requestManagement.loadBalancer;

import requests.HttpRequest;
import responses.HttpResponse;

import java.io.IOException;

public interface LoadBalancer {

    HttpResponse executeRequest(HttpRequest request) throws IOException;
    static LoadBalancerBuilder getBuilder() {
        return new LoadBalancerBuilder();
    }

}
