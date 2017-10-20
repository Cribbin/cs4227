package requestManagement.loadBalancer;

import requestManagement.fleetManager.FleetManager;

public class LBRoundRobin extends LBStrategy {

    public LBRoundRobin(FleetManager fleetManager) {
        super(fleetManager);
    }

    @Override
    public String getNextHost(){
        return "round robin";
    }
}
