package requestManagement.fleetManager;

import requestManagement.fleetManager.hosts.Host;

import java.util.List;

public class HeathCheckImplementation implements HealthCheck {

    private FleetManager fleetManager;
    private Host host = null;
    private List<Host> allHosts;

    public HeathCheckImplementation() {}

    @Override
    public void runHealthCheck() {
        fleetManager = FleetManager.getInstance();
        fleetManager.addHost(host);
        fleetManager.removeHost(host);
        fleetManager.disableHost(host);
        fleetManager.enableHost(host);
        allHosts = fleetManager.getHosts();
    }
}
