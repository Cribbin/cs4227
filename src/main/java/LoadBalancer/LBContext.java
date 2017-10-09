package LoadBalancer;

public class LBContext {
    private LBStrategy strategy;

    public LBContext(LBStrategy strategy) {
        this.strategy = strategy;
    }


}
