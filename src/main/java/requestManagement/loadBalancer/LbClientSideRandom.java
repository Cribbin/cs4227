package requestManagement.loadBalancer;

import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.hosts.Host;

public class LbClientSideRandom extends LbStrategy {

    public LbClientSideRandom(FleetManager fleetManager) {
        super(fleetManager);
    }

    @Override
    public Host getNextHost() {
        return fleetManager.getHosts().get(0);
    }
}
