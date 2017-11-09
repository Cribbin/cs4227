package requestManagement.fleetManager.hosts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class HostTest {
    private static final String VALID_PRIVATE_IP = "10.0.0.1";
    private static final String DNS_NAME = "testDns";
    private static final int PORT_80 = 80;
    private static final String ACTIVE_STATE = "active";
    private static final String INACTIVE_STATE = "inactive";
    private static final String INVALID_STATE = "invalidState";
    private static final int MAX_CONNECTIONS = 17;

    private Host host;

    @BeforeEach
    void setUp() {
        host = new Host.HostBuilder(VALID_PRIVATE_IP)
                .withDns(DNS_NAME)
                .withPort(PORT_80)
                .withState(ACTIVE_STATE)
                .withMaxConnections(MAX_CONNECTIONS)
                .build();
    }

    @Test
    void shouldCreateActiveHostWithPrivateIp() {
        assert host.getDns().equals(DNS_NAME);
        assert host.getPort() == PORT_80;
        assert host.getState().toString().equals(ACTIVE_STATE);
        assert host.isActive();
        assert host.getIpv4().equals(VALID_PRIVATE_IP);
        assert host.getMaxConnections() == MAX_CONNECTIONS;
    }

    @Test
    void shouldUpdateHostState() {
        host.setState(INACTIVE_STATE);
        assert host.getState().toString().equals(INACTIVE_STATE);
        assert !host.isActive();
    }

    @Test
    void shouldThrowExceptionWithInvalidState() {
        assertThrows(IllegalArgumentException.class,
            () -> new Host.HostBuilder(VALID_PRIVATE_IP)
                    .withDns(DNS_NAME)
                    .withPort(PORT_80)
                    .withMaxConnections(MAX_CONNECTIONS)
                    .withState(INVALID_STATE)
                    .build());
    }
}
