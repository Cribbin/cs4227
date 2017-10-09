package LoadBalancer;

public class LBRoundRobin implements LBStrategy {
    public String balanceLoad(){
        return "round robin";
    }
}
