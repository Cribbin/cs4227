package requestManagement.fleetManager.hosts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class HostTest {
    private static final String VALID_PRIVATE_IP = "10.0.0.1";
    private static final String DNS_NAME = "testDns";
    private static final String PORT_80 = "80";
    private static final String ACTIVE_STATE = "active";
    private static final String INACTIVE_STATE = "inactive";
    private static final String INVALID_STATE = "invalidState";
    private static final String PRIVATE_SUBNET = "private";

    private Host host;

    @BeforeEach
    void setUp() {
        host = new Host.HostBuilder(VALID_PRIVATE_IP)
                .withDns(DNS_NAME)
                .withPort(PORT_80)
                .withState(ACTIVE_STATE)
                .build();
    }

    @Test
    void shouldCreateActiveHostWithPrivateIp() {
        assert host.getDns().equals(DNS_NAME);
        assert host.getPort().equals(PORT_80);
        assert host.getState().equals(ACTIVE_STATE);
        assert host.getIpv4().equals(VALID_PRIVATE_IP);
        assert !host.isPublicIp();
    }

    @Test
    void shouldUpdateHostState() {
        host.setState(INACTIVE_STATE);

        assert host.getState().equals(INACTIVE_STATE);
    }

    @Test
    void shouldThrowExceptionWithInvalidState() {
        assertThrows(IllegalArgumentException.class,
            () -> new Host.HostBuilder(VALID_PRIVATE_IP)
                    .withDns(DNS_NAME)
                    .withPort(PORT_80)
                    .withState(INVALID_STATE)
                    .build());
    }
}
