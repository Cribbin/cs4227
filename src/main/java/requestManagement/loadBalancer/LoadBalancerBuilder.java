package requestManagement.loadBalancer;

import requestManagement.fleetManager.FleetManager;

public class LoadBalancerBuilder {

    private LBStrategy loadBalancingStrategy;
    private FleetManager fleetManager;

    LoadBalancerBuilder() {
    }

    public LoadBalancerBuilder withLoadBalancingStrategy(LBStrategy loadBalancingStrategy) {
        this.setLoadBalancingStrategy(loadBalancingStrategy);

        return this;
    }

    public LoadBalancerBuilder withFleetManager(FleetManager fleetManager) {
        this.setFleetManager(fleetManager);

        return this;
    }

    private void setLoadBalancingStrategy(LBStrategy loadBalancingStrategy) {
        this.loadBalancingStrategy = loadBalancingStrategy;
    }

    private void setFleetManager(FleetManager fleetManager){
        this.fleetManager = fleetManager;
    }

    LBStrategy getLoadBalancingStrategy(){
        return loadBalancingStrategy;
    }

    FleetManager getFleetManager(){
        return fleetManager;
    }

    public LoadBalancerImpl build(){
        return new LoadBalancerImpl(this);
    }
}
