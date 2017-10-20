import org.junit.jupiter.api.*;
import org.mockito.*;
import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.hosts.Host;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;


class TestFleetManagement {
    private static final String ACTIVE_HOST = "active";
    private static final String INACTIVE_HOST = "inactive";
    private static final String IP_1 = "127.0.0.1";
    private static final String IP_2 = "127.0.0.2";
    private static final String IP_3 = "127.0.0.3";
    private static final String DNS = "SampleDNS";
    private static final String PORT_80 = "80";

    private FleetManager fleetManager;
    private Host testHost1;
    private Host testHost2;
    private Host testHost3;
    private List<Host> hostsFromFile;

    @BeforeEach
    void setUp() {
        /* Requests instance of FleetManager */
        fleetManager = mock(FleetManager.class);

        testHost1 = new Host.HostBuilder(IP_1)
            .withDns(DNS)
            .withPort(PORT_80)
            .withState(ACTIVE_HOST)
            .build();

        testHost2 = new Host.HostBuilder(IP_2)
            .withDns(DNS)
            .withPort(PORT_80)
            .withState(ACTIVE_HOST)
            .build();

        testHost3 = new Host.HostBuilder(IP_3)
            .withDns(DNS)
            .withPort(PORT_80)
            .withState(INACTIVE_HOST)
            .build();
    }

    @Test
    void testAddingHosts() {}
}
