package requestManagement.fleetManager;

import requestManagement.fleetManager.hosts.Host;

import java.util.List;

public class HealthCheckImplementation implements HealthCheck {

    private FleetManager fleetManager;
    private List<Host> allHosts;

    public HealthCheckImplementation() {}

    @Override
    public void runHealthCheck() {
        fleetManager = FleetManager.getInstance();
    }
}
