package requestManagement.loadBalancer;

import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.hosts.ActiveHost;

public abstract class LbStrategy {

    public LbStrategy(FleetManager fleetManager) {}

    public abstract ActiveHost getNextHost();
}
