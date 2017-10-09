package LoadBalancer;

public class LBClientSideRandom implements LBStrategy {
    public String balanceLoad() {
        return "Client Side";
    }
}
