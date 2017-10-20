import LoadBalancer.LBRoundRobin;
import LoadBalancer.LBStrategy;
import LoadBalancer.LoadBalancer;
import org.junit.jupiter.api.Test;

public class LoadBalancerTest {
    @Test
    void loadBalancerBuilderTest() {
        String fleetManager = new String();
        LBStrategy loadBalancingStrategy = new LBRoundRobin(fleetManager);

        LoadBalancer loadBalancer = LoadBalancer.getBuilder()
                .withLoadBalancingStrategy(loadBalancingStrategy)
                .withFleetManager(fleetManager)
                .build();
    }
}
