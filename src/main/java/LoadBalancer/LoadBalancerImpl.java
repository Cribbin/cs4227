package LoadBalancer;

public class LoadBalancerImpl  implements LoadBalancer {
    private LBStrategy loadBalancingStrategy;
    private String fleetManager;

    LoadBalancerImpl(LoadBalancerBuilder builder) {
        loadBalancingStrategy = builder.getLoadBalancingStrategy();
        fleetManager = builder.getFleetManager();
    }

    public String executeStrategy() { return loadBalancingStrategy.getNextHost(); }

    public LBStrategy getLoadBalancingStrategy() {
        return loadBalancingStrategy;
    }

    public String getFleetManager() {
        return fleetManager;
    }

}
