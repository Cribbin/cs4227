package requestManagement.fleetManager.healthCheck;

import requestManagement.fleetManager.FleetManager;

public class HealthCheckImplementation {
    private FleetManager fleetManager;

    public HealthCheckImplementation(FleetManager fleetManager) {
        this.fleetManager = fleetManager;
    }

    public void execute(HealthCheckStrategy strategy) {
        strategy.runHealthCheck(this.fleetManager);

        if (fleetManager.getNumActiveHosts() < 2) {
            // Add new host(s)
        }
    }
}
