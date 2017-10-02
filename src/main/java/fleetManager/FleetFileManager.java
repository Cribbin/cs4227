package fleetManager;

import fleetManager.hosts.Host;

import java.util.List;

public class FleetFileManager implements IFleetFileManager {

    private List<Host> hosts;

    FleetFileManager(){

    }

    public List<Host> getHosts(){
        return hosts;
    }

    public void updateHost(Host host){}

    public void addHost(Host host){}

    public void removeHost(Host host){}
}
