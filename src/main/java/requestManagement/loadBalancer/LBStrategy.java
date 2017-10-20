package requestManagement.loadBalancer;

import requestManagement.fleetManager.FleetManager;

public abstract class LBStrategy {


    public LBStrategy(FleetManager fleetManager) {}

    public abstract String getNextHost();
}
