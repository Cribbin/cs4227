package LoadBalancer;

public class LBClientSideRandom extends LBStrategy {

    public LBClientSideRandom(String fleetManager) {
        super(fleetManager);
    }

    @Override
    public String getNextHost() {
        return "Client Side";
    }

}
