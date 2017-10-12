package requestManagement.fleetManager;

import requestManagement.fleetManager.hosts.Host;

import java.util.List;

public class HeathCheckImplementation implements HealthCheck {

    private FleetManager fleetManager;
    private List<Host> allHosts;

    public HeathCheckImplementation() {}

    @Override
    public void runHealthCheck() {
        fleetManager = FleetManager.getInstance();
    }
}
