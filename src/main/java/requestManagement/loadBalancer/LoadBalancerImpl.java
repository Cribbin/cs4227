package requestManagement.loadBalancer;

import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.hosts.ActiveHost;

public class LoadBalancerImpl implements LoadBalancer {
    private LBStrategy loadBalancingStrategy;
    private FleetManager fleetManager;

    LoadBalancerImpl(LoadBalancerBuilder builder) {
        loadBalancingStrategy = builder.getLoadBalancingStrategy();
        fleetManager = builder.getFleetManager();
    }

    ActiveHost executeStrategy() {
        return loadBalancingStrategy.getNextHost();
    }

    public LBStrategy getLoadBalancingStrategy() {
        return loadBalancingStrategy;
    }

    public FleetManager getFleetManager() {
        return fleetManager;
    }
}
