package fleetManager;

import fleetManager.hosts.Host;

public interface IFleetManager {
    void addHost(Host host);
    void removeHost(Host host);
    void enableHost(Host host);
    void disableHost(Host host);
    void getHosts();
}
