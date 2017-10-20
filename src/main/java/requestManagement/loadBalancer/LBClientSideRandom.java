package requestManagement.loadBalancer;

import requestManagement.fleetManager.FleetManager;

public class LBClientSideRandom extends LBStrategy {

    public LBClientSideRandom(FleetManager fleetManager) {
        super(fleetManager);
    }

    @Override
    public String getNextHost() {
        return "Client Side";
    }

}
