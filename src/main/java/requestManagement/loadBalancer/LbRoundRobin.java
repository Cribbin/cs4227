package requestManagement.loadBalancer;

import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.hosts.ActiveHost;

public class LbRoundRobin extends LBStrategy {

    public LbRoundRobin(FleetManager fleetManager) {
        super(fleetManager);
    }

    @Override
    public ActiveHost getNextHost() {
        return new ActiveHost();
    }
}
