package requestManagement.fleetManager.healthCheck;

import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.hosts.Host;

public class HealthCheckImplementation {
    private FleetManager fleetManager;

    public HealthCheckImplementation(FleetManager fleetManager) {
        this.fleetManager = fleetManager;
    }

    public void execute(HealthCheckStrategy strategy) {
        strategy.runHealthCheck(this.fleetManager);

        int numActiveHosts = 0;

        for (Host host : fleetManager.getHosts()) {
            if (host.getState().toString().equals("active")) {
                numActiveHosts++;
            }
        }

        if (numActiveHosts < 2) {
            fleetManager.addHost(spinUpNewHost());
        }
    }

    private Host spinUpNewHost() {
        return new Host.HostBuilder("ip").build();
    }
}
