package requestManagement.loadBalancer;

import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.hosts.Host;

public abstract class LbStrategy {
    protected FleetManager fleetManager;

    public LbStrategy(FleetManager fleetManager) {
        this.fleetManager = fleetManager;
    }

    public abstract Host getNextHost();
}
