package LoadBalancer;

public class LoadBalancerBuilder {

    private LBStrategy loadBalancingStrategy;
    private String fleetManager;

    LoadBalancerBuilder() {
    }

    public LoadBalancerBuilder withLoadBalancingStrategy(LBStrategy loadBalancingStrategy) {
        this.setLoadBalancingStrategy(loadBalancingStrategy);

        return this;
    }

    public LoadBalancerBuilder withFleetManager(String fleetManager) {
        this.setFleetManager(fleetManager);

        return this;
    }

    private void setLoadBalancingStrategy(LBStrategy loadBalancingStrategy) {
        this.loadBalancingStrategy = loadBalancingStrategy;
    }

    private void setFleetManager(String fleetManager){
        this.fleetManager = fleetManager;
    }

    LBStrategy getLoadBalancingStrategy(){
        return loadBalancingStrategy;
    }

    String getFleetManager(){
        return fleetManager;
    }

    public LoadBalancerImpl build(){
        return new LoadBalancerImpl(this);
    }
}
