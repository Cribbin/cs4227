package requestManagement.fleetManager.hosts;

public class Host {
    private HostState hostState;
    private HostStateFactory hostStateFactory;
    private final String ipv4;
    private final String DNS;
    private String port;
    private final boolean publicIP;
    private String state;

    public Host(String state, String ipv4, String dns, String port, boolean publicIP) {
        this.ipv4 = ipv4;
        this.state = state;
        DNS = dns;
        this.port = port;
        this.publicIP = publicIP;
        hostStateFactory = new HostStateFactory();
        hostState = hostStateFactory.hostState(state);
    }

    public String getIpv4() {
        return ipv4;
    }

    public String getDNS() {
        return DNS;
    }

    public String getPort() {
        return port;
    }

    public String getState() {
        return state;
    }

    public String getSubnet() {
        return publicIP ?  "public" : "private";
    }

    public void setState(String state) {
        this.state = state;
        hostState = hostStateFactory.hostState(state);
    }

    public void setPort(String port) {
        this.port = port;
    }

    public boolean isPublicIp() {
        return publicIP;
    }
}
