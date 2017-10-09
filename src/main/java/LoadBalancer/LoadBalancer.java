package LoadBalancer;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

public class LoadBalancer {
    private LBStrategy loadBalancingStrategy;
    private String fleetManager;

    public LBStrategy getLoadBalancingStrategy() {
        return loadBalancingStrategy;
    }

    public String getFleetManager() {
        return fleetManager;
    }

    HttpResponse handleRequest(HttpRequest request){
        HttpResponse response = null;
        return response;
    }

    public String executeStrategy(){
        return loadBalancingStrategy.balanceLoad();
    };

    private LoadBalancer(LoadBalancerBuilder builder){
        this.loadBalancingStrategy=builder.loadBalancingStrategy;
        this.fleetManager=builder.fleetManager;
    }

    public static class LoadBalancerBuilder{

        private LBStrategy loadBalancingStrategy;
        private String fleetManager;

        public LoadBalancerBuilder() {
        }

        public LoadBalancerBuilder withLoadBalancingStrategy(LBStrategy loadBalancingStrategy){
            this.setLoadBalancingStrategy(loadBalancingStrategy);

            return this;
        }

        public LoadBalancerBuilder withFleetManager(String fleetManager){
            this.setFleetManager(fleetManager);

            return this;
        }

        private void setLoadBalancingStrategy(LBStrategy loadBalancingStrategy){
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



        public LoadBalancer build(){
            return new LoadBalancer(this);
        }
    }
}
