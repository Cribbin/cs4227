package requestManagement.fleetManager.storage;

import requestManagement.fleetManager.hosts.Host;

import java.util.List;

public class HostDAOJSON implements HostDAO {

    HostDAOJSON(){}

    @Override
    public void addHost(Host host){}

    @Override
    public void disableHost(Host host) {}

    @Override
    public void removeHost(Host host) {}

    @Override
    public void enableHost(Host host) {}

    @Override
    public List<Host> getHosts() {
        return null;
    }
}
