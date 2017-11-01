package requests.generators;

import org.apache.http.client.methods.HttpRequestBase;
import requestManagement.fleetManager.hosts.Host;
import requests.HttpRequest;

@FunctionalInterface
public interface RequestGenerator {
    HttpRequestBase generateRequest(HttpRequest request, Host host);
}