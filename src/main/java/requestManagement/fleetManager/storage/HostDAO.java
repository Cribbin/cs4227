package requestManagement.fleetManager.storage;

import requestManagement.fleetManager.hosts.Host;

import java.util.List;

public interface HostDAO {
    void addHost(Host host);
    void removeHost(Host host);
    void enableHost(Host host);
    void disableHost(Host host);
    List<Host> getHosts();
}
