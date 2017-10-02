package fleetManager.hosts;

public class Host {
    private HostState hostState;
    private HostStateFactory hostStateFactory;
    private String ipv4;
    private String DNS;
    private String port;

    public Host(String state){
        hostStateFactory =new HostStateFactory();
        hostState= hostStateFactory.hostState(state);
    }
}
