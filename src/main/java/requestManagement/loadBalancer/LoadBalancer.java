package requestManagement.loadBalancer;

import requests.HttpRequest;
import responses.HttpResponse;

public interface LoadBalancer {

    HttpResponse executeRequest(HttpRequest request);
    static LoadBalancerBuilder getBuilder() {
        return new LoadBalancerBuilder();
    }

}
