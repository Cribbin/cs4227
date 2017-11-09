package requestManagement.fleetManager.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import requestManagement.fleetManager.hosts.Host;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class HostDAOFileSystemTest {
    private static final String VALID_PRIVATE_IP_1 = "10.0.0.1";
    private static final String VALID_PRIVATE_IP_2 = "10.0.0.2";
    private static final String VALID_PRIVATE_IP_3 = "10.0.0.3";
    private static final String DNS_NAME_1 = "testDns1";
    private static final String DNS_NAME_2 = "testDns2";
    private static final int PORT_80 = 80;
    private static final int MAX_CONNECTIONS_1 = 16;
    private static final int MAX_CONNECTIONS_2 = 18;
    private static final String ACTIVE_STATE = "active";
    private static final String INACTIVE_STATE = "inactive";

    private final ClassLoader classLoader = getClass().getClassLoader();

    private HostDAOFileSystem dao;

    @BeforeEach
    void setUp() {
        String file = classLoader.getResource("resources/testHostFile.txt").getFile();
        System.out.println(file);
        dao = new HostDAOFileSystem(file);

        Host host1 = getHost(VALID_PRIVATE_IP_1, DNS_NAME_1, ACTIVE_STATE, MAX_CONNECTIONS_1);
        Host host2 = getHost(VALID_PRIVATE_IP_2, DNS_NAME_2, INACTIVE_STATE, MAX_CONNECTIONS_2);

        try {
            FileWriter fw = new FileWriter(file, false);
            fw.write(host1.toString());
            fw.write(host2.toString());
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    @Test
    void shouldGetHostsFromFile() {
       List<Host> hosts = dao.getHosts();

       assert hosts.size() == 2;

       assertHost(hosts.get(0), VALID_PRIVATE_IP_1, DNS_NAME_1, ACTIVE_STATE, MAX_CONNECTIONS_1);
       assertHost(hosts.get(1), VALID_PRIVATE_IP_2, DNS_NAME_2, INACTIVE_STATE, MAX_CONNECTIONS_2);
    }

    @Test
    void shouldAddHostsToFile() {
        List<Host> hosts = dao.getHosts();

        assert hosts.size() == 2;

        Host host = new Host.HostBuilder(VALID_PRIVATE_IP_3)
                .withDns(DNS_NAME_1)
                .withState(ACTIVE_STATE)
                .withPort(PORT_80)
                .withMaxConnections(MAX_CONNECTIONS_1)
                .build();

        dao.addHost(host);

        hosts = dao.getHosts();

        assert hosts.size() == 3;
    }

    private Host getHost(String ip, String dns, String state, int maxConnections) {
       return new Host.HostBuilder(ip)
               .withDns(dns)
               .withPort(PORT_80)
               .withMaxConnections(maxConnections)
               .withState(state)
               .build();
    }

    private void assertHost(Host host, String ip, String dns, String state, int maxConnections) {
        assert host.getIpv4().equals(ip);
        assert host.getDns().equals(dns);
        assert host.getPort() == PORT_80;
        assert host.getMaxConnections() == maxConnections;
        assert host.getState().toString().equals(state);
    }

}
