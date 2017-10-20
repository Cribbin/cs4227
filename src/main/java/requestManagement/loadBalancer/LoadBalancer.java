package requestManagement.loadBalancer;

public interface LoadBalancer {

    static LoadBalancerBuilder getBuilder() {
        return new LoadBalancerBuilder();
    }

}
