package requestManagement.fleetManager.hosts;

/**
 * Defines a Host object
 *
 * This object can be created by data from the storage system or possibly by user input in the future.
 */
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

    /** Returns a string value of the ipv4 of a host */
    public String getIpv4() {
        return ipv4;
    }

    /** Returns a string value of the DNS of a host */
    public String getDNS() {
        return DNS;
    }

    /** Returns a string value of the port open of a host */
    public String getPort() {
        return port;
    }

    /** Returns a string value of the state of a host */
    public String getState() {
        return state;
    }

    /** Returns a string value of the subnet type of a host */
    public String getSubnet() {
        return publicIP ?  "public" : "private";
    }

    /** Sets the state of a host */
    public void setState(String state) {
        this.state = state;
        hostState = hostStateFactory.hostState(state);
    }

    /** Sets the open port of a host */
    public void setPort(String port) {
        this.port = port;
    }

    /** Returns a boolean value to determine whether the host has a public ip */
    public boolean isPublicIp() {
        return publicIP;
    }

    /** Overrides the toString method for this object */
    @Override
    public String toString() {
        return this.getIpv4() + "," + this.getDNS() + "," + this.getPort() + "," + this.getState() + "," + this.getSubnet();
    }
}
