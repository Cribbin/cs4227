package LoadBalancer;

public abstract class LBStrategy {


    public LBStrategy(String fleetManager) {}

    public abstract String getNextHost();
}
