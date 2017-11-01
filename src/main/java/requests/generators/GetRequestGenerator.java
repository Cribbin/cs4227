package requests.generators;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import requestManagement.fleetManager.hosts.Host;
import requests.HttpRequest;

import java.net.URI;
import java.net.URISyntaxException;

public class GetRequestGenerator implements RequestGenerator {

    @Override
    public HttpRequestBase generateRequest(HttpRequest request, Host host) {
        String endUri = null;
        try {
            URI originalUri = new URI(request.getUri());

            StringBuilder uriBuilder = new StringBuilder();
            uriBuilder.append("https://");
            uriBuilder.append(host.getDns());
            if(originalUri.getPath() != null) uriBuilder.append(originalUri.getPath());
            if(originalUri.getQuery() != null) uriBuilder.append("?" + originalUri.getQuery());

            endUri = uriBuilder.toString();

        } catch(URISyntaxException ex) {
            // TODO: Log this
        }

        return new HttpGet(endUri);
    }
}
