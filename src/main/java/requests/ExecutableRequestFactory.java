package requests;

import org.apache.http.client.methods.HttpRequestBase;
import requestManagement.fleetManager.hosts.Host;
import requests.generators.GetRequestGenerator;
import requests.generators.PostRequestGenerator;
import requests.generators.PutRequestGenerator;
import requests.generators.RequestGenerator;

import java.util.HashMap;
import java.util.Map;

/**
 * Factory class that builds Executable HTTP Requests from the Facade HttpRequest object that we have created.
 */
public class ExecutableRequestFactory {

    Map<String, RequestGenerator> requestGenerators;

    public ExecutableRequestFactory() {
        this.requestGenerators = initialiseGenerators();
    }

    public HttpRequestBase getExecutableRequest(HttpRequest request, Host host) {
        return requestGenerators.get(request.getMethod()).generateRequest(request, host);
    }

    private Map<String, RequestGenerator> initialiseGenerators() {
        Map<String, RequestGenerator> generators = new HashMap<>();

        generators.put("GET", new GetRequestGenerator());
        generators.put("POST", new PostRequestGenerator());
        generators.put("PUT", new PutRequestGenerator());

        return generators;
    }
}
