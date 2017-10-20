package LoadBalancer;

public class LBRoundRobin extends LBStrategy {

    public LBRoundRobin(String fleetManager){
        super(fleetManager);
    }

    @Override
    public String getNextHost(){
        return "round robin";
    }
}
