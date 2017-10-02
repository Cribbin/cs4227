package fleetManager;

import fleetManager.hosts.Host;

import java.util.List;

public interface IFleetFileManager {
    List<Host> getHosts();
    void updateHost(Host host);
    void addHost(Host host);
    void removeHost(Host host);
}
