import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requestManagement.Dispatcher;
import requestManagement.RequestManager;
import requestManagement.Service;
import requestManagement.fleetManager.FleetManager;
import requestManagement.loadBalancer.LoadBalancer;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class TestRequestManagement {

    private Collection<Service> services = null;
    private Service service = null;
    private Dispatcher dispatcher = null;

    @BeforeEach
    void setUp() {

        /* Create new service collection with single mock service. */
        services = new ArrayList<>();
        service = mock(Service.class);
        services.add(service);

        dispatcher = new Dispatcher(services);
    }

    @Test
    void testDispatcherEventDispatching() {

        /* Test that the dispatcher is correctly dispatching both events */

        dispatcher.dispatchIncomingRequest(null);
        dispatcher.dispatchOutgoingResponse(null);

        /* Check that each event was dispatched to the subscribed service exactly once */
        verify(service, times(1)).processIncomingRequest(null);
        verify(service, times(1)).processOutgoingResponse(null);
    }

    @Test
    void testDispatcherDeregister() {

        /* Remove service from dispatcher notification collection and ensure it does not receive the event. */

        dispatcher.deregister(service);
        dispatcher.dispatchIncomingRequest(null);
        dispatcher.dispatchOutgoingResponse(null);

        verify(service, times(0)).processIncomingRequest(null);
        verify(service, times(0)).processOutgoingResponse(null);
    }

    @Test
    void testRequestManagerBuilder() {
        Dispatcher dispatcher = new Dispatcher(services);
        LoadBalancer loadBalancer = null;
        FleetManager fleetManager = FleetManager.getInstance();

        /* Test that the request manager builds successfully with valid member variables */
        RequestManager requestManager = RequestManager.getBuilder()
                .withFleetManager(fleetManager)
                .withLoadBalancer(loadBalancer)
                .withDispatcher(dispatcher)
                .build();

        /* TODO: Should eventually raise argument exceptions when invalid dependency classes are passed and test such cases */
    }
}
