import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requestManagement.Context;
import requestManagement.Dispatcher;
import requestManagement.RequestManager;
import requestManagement.Service;
import requestManagement.fleet.FleetManager;
import requestManagement.loadBalancing.LoadBalancer;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TestRequestManagement {

    private Collection<Service> services = null;
    private Service exampleService = null;

    @BeforeEach
    void setUp() {
        services = new ArrayList<>();

        exampleService = new Service() {

            @Override
            public void processIncomingRequest(HttpRequest request, Context context) {

            }

            @Override
            public void processOutgoingResponse(HttpResponse response, Context context) {

            }

        };

        services.add(exampleService);
    }

    @Test
    public void testDispatcher() {

        /* Create new service collection with single mock service. */
        Collection<Service> services = new ArrayList<>();
        Service service = mock(Service.class);
        services.add(service);

        /* Test that the dispatcher is correctly dispatching both events */
        Dispatcher dispatcher = new Dispatcher(services);

        dispatcher.dispatchIncomingRequest(null, null);

        dispatcher.dispatchOutgoingResponse(null, null);

        /* Check that each event was dispatched to the subscribed service exactly once */
        verify(service, times(1)).processIncomingRequest(null, null);
        verify(service, times(1)).processOutgoingResponse(null, null);
    }

    @Test
    public void testRequestManagerBuilder() {
        Dispatcher dispatcher = new Dispatcher(services);
        Context context = new Context();
        LoadBalancer loadBalancer = new LoadBalancer();
        FleetManager fleetManager = new FleetManager();

        /* Test that the request manager builds successfully with valid member variables */
        RequestManager requestManager = RequestManager.getBuilder()
                .withFleetManager(fleetManager)
                .withLoadBalancer(loadBalancer)
                .withContext(context)
                .withDispatcher(dispatcher)
                .build();

        /* TODO: Should eventually raise argument exceptions when invalid dependency classes are passed and test such cases */
    }
}
