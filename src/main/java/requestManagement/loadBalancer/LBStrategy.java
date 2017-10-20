package requestManagement.loadBalancer;

import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.hosts.ActiveHost;

public abstract class LBStrategy {

    public LBStrategy(FleetManager fleetManager) {}

    public abstract ActiveHost getNextHost();
}
