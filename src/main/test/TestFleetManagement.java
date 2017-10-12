import org.junit.jupiter.api.*;
import org.mockito.*;
import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.hosts.Host;

import java.util.List;


import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;


class TestFleetManagement {

    private FleetManager fleetManager;
    private Host testHost1;
    private Host testHost2;
    private Host testHost3;
    private List<Host> hostsFromFile;

    @BeforeEach
    void setUp() {

        /* Requests instance of FleetManager */
        fleetManager = mock(FleetManager.class);
        testHost1=new Host("active","127.0.0.1","SampleDNS","80",true);
        testHost2=new Host("active","127.0.0.2","SampleDNS","80",false);
        testHost3=new Host("inactive","127.0.0.3","SampleDNS","80",true);
    }

    @Test
    void testAddingHosts() {
    }
}
