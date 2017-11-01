package requestManagement.loadBalancer;

import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.hosts.Host;

public class LbRoundRobin extends LbStrategy {

    public LbRoundRobin(FleetManager fleetManager) {
        super(fleetManager);
    }

    @Override
    public Host getNextHost() {
        return null;//new Host();
    }
}
