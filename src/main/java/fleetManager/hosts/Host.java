package fleetManager.hosts;

public class Host {
    private HostState hostState;
    private HostStateFactory hostStateFactory;
    private final String ipv4;
    private final String DNS;
    private String port;

    public Host(String state, String ipv4, String dns, String port){
        this.ipv4 = ipv4;
        DNS = dns;
        this.port = port;
        hostStateFactory =new HostStateFactory();
        hostState= hostStateFactory.hostState(state);
    }
}
