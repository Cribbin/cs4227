import org.junit.jupiter.api.*;
import org.mockito.*;
import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.hosts.Host;
import static org.mockito.Mockito.mock;


class TestFleetManagement {

    private FleetManager fleetManager;

    @Mock
    private Host host;

    @BeforeEach
    void setUp() {

        /* Requests instance of FleetManager */
        fleetManager = mock(FleetManager.class);
    }

    @Test
    void testAddingHosts() {

        /* Test that the dispatcher is correctly dispatching both events */
        fleetManager.addHost(host);
    }

    @Test
    void testRemovingHosts() {

        /* Test that the dispatcher is correctly dispatching both events */
        fleetManager.removeHost(host);
    }

    @Test
    void testEnablingHosts() {

        /* Test that the dispatcher is correctly dispatching both events */
        fleetManager.enableHost(host);
    }

    @Test
    void testDisablingHosts() {

        /* Test that the dispatcher is correctly dispatching both events */
        fleetManager.disableHost(host);
    }

    @Test
    void testGettingListOfHosts() {

        /* Test that the dispatcher is correctly dispatching both events */
        fleetManager.getHosts();
    }
}
