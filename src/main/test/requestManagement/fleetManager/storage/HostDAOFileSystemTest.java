package requestManagement.fleetManager.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requestManagement.fleetManager.hosts.Host;

import java.util.List;

class HostDAOFileSystemTest {
    private static final String VALID_PRIVATE_IP_1 = "10.0.0.1";
    private static final String VALID_PRIVATE_IP_2 = "10.0.0.2";
    private static final String DNS_NAME_1 = "testDns1";
    private static final String DNS_NAME_2 = "testDns2";
    private static final String PORT_80 = "80";
    private static final String ACTIVE_STATE = "active";
    private static final String INACTIVE_STATE = "inactive";
    private static final String PRIVATE_SUBNET = "private";

    private final ClassLoader classLoader = getClass().getClassLoader();

    private HostDAOFileSystem dao;

    @BeforeEach
    void setUp() {
        String file = classLoader.getResource("resources/testHostFile.txt").getFile();
        dao = new HostDAOFileSystem(file);
    }

    @Test
    void shouldGetHostsFromFile() {
       List<Host> hosts = dao.getHosts();

       assert hosts.size() == 2;

       assertHost(hosts.get(0), VALID_PRIVATE_IP_1, DNS_NAME_1, ACTIVE_STATE);
       assertHost(hosts.get(1), VALID_PRIVATE_IP_2, DNS_NAME_2, INACTIVE_STATE);
    }

    private void assertHost(Host host, String ip, String dns, String state) {
        assert host.getIpv4().equals(ip);
        assert host.getDns().equals(dns);
        assert host.getPort().equals(PORT_80);
        assert host.getState().equals(state);
        assert host.getSubnet().equals(PRIVATE_SUBNET);
    }

}
