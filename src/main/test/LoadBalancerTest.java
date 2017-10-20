import requestManagement.fleetManager.FleetManager;
import requestManagement.loadBalancer.LbRoundRobin;
import requestManagement.loadBalancer.LBStrategy;
import requestManagement.loadBalancer.LoadBalancer;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;

public class LoadBalancerTest {
    @Test
    void loadBalancerBuilderTest() {
        FleetManager fleetManager = mock(FleetManager.class);
        LBStrategy loadBalancingStrategy = new LbRoundRobin(fleetManager);

        LoadBalancer loadBalancer = LoadBalancer.getBuilder()
                .withLoadBalancingStrategy(loadBalancingStrategy)
                .withFleetManager(fleetManager)
                .build();
    }
}
