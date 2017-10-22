package requestManagement.fleetManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requestManagement.fleetManager.hosts.Host;

import java.util.Collections;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HealthCheckImplementationTest {
    private static final String LOOPBACK_IP = "127.0.0.1";
    private static final String INVALID_IP = "999.999.999";
    private static final String DNS = "testDns";
    private static final int PORT_80 = 80;
    private static final String ACTIVE_STATE = "active";
    private static final String INACTIVE_STATE = "inactive";

    private HealthCheckImplementation healthCheck;
    private FleetManager fleetManager;

    @BeforeEach
    void setUp() {
        fleetManager = mock(FleetManager.class);
        healthCheck = new HealthCheckImplementation(fleetManager);
    }

    @Test
    void shouldPingLocalHostAndUpdateState() {
        Host localHost = getHost(LOOPBACK_IP, INACTIVE_STATE);
        assertState(localHost, INACTIVE_STATE);

        healthCheck.runHealthCheck();
        assertState(localHost, ACTIVE_STATE);
    }

    @Test
    void shouldPingLocalHostAndNotChangeActiveState() {
        Host localHost = getHost(LOOPBACK_IP, ACTIVE_STATE);
        assertState(localHost, ACTIVE_STATE);

        healthCheck.runHealthCheck();
        assertState(localHost, ACTIVE_STATE);
    }

    @Test
    void shouldFailPingingNonExistingHostAndUpdateState() {
        Host deadHost = getHost(INVALID_IP, ACTIVE_STATE);
        assertState(deadHost, ACTIVE_STATE);

        healthCheck.runHealthCheck();
        assertState(deadHost, INACTIVE_STATE);
    }

    @Test
    void shouldFailPingingNonExistingHostAndNotChangeInactiveState() {
        Host deadHost = getHost(INVALID_IP, INACTIVE_STATE);
        assertState(deadHost, INACTIVE_STATE);

        healthCheck.runHealthCheck();
        assertState(deadHost, INACTIVE_STATE);
    }

    private Host getHost(String ip, String state) {
        Host h = new Host.HostBuilder(ip)
                .withDns(DNS)
                .withPort(PORT_80)
                .withState(state)
                .build();

        when(fleetManager.getHosts()).thenReturn(Collections.singletonList(h));
        doAnswer(i -> setState(h, "active")).when(fleetManager).enableHost(h);
        doAnswer(i -> setState(h, "inactive")).when(fleetManager).disableHost(h);
        return h;
    }

    private void assertState(Host host, String state) {
        assert host.getState().toString().equals(state);
    }

    private Object setState(Host h, String state) {
        h.setState(state);
        return null;
    }
}
