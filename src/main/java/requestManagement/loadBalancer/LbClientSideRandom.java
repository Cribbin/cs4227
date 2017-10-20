package requestManagement.loadBalancer;

import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.hosts.ActiveHost;

public class LbClientSideRandom extends LBStrategy {

    public LbClientSideRandom(FleetManager fleetManager) {
        super(fleetManager);
    }

    @Override
    public ActiveHost getNextHost() {
        return new ActiveHost();
    }

}
