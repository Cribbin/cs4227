package requestManagement.loadBalancer;

import requestManagement.fleetManager.FleetManager;

public class LoadBalancerImpl  implements LoadBalancer {
    private LBStrategy loadBalancingStrategy;
    private FleetManager fleetManager;

    LoadBalancerImpl(LoadBalancerBuilder builder) {
        loadBalancingStrategy = builder.getLoadBalancingStrategy();
        fleetManager = builder.getFleetManager();
    }

    public String executeStrategy() { return loadBalancingStrategy.getNextHost(); }

    public LBStrategy getLoadBalancingStrategy() {
        return loadBalancingStrategy;
    }

    public FleetManager getFleetManager() {
        return fleetManager;
    }

}
