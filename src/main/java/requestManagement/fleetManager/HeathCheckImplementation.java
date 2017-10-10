package requestManagement.fleetManager;

import requestManagement.fleetManager.hosts.Host;

import java.util.List;

public class HeathCheckImplementation implements HealthCheck {

    private FleetManager fleetManager;
    private Host host;
    private List<Host> allHosts;

    public HeathCheckImplementation() {
        host= new Host("1","111","1","1",true);
    }

    @Override
    public void runHealthCheck() {
        fleetManager = FleetManagerImplementation.getInstance();
        fleetManager.addHost(host);
        fleetManager.removeHost(host);
        fleetManager.disableHost(host);
        fleetManager.enableHost(host);
        allHosts = fleetManager.getHosts();
    }
}
