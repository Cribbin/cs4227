package requestManagement.fleetManager.hosts;

/**
 * Defines a Host object
 *
 * This object can be created by data from the storage system or possibly by user input in the future.
 */
public class Host {
    private final String ipv4;
    private final boolean publicIp;
    private final String dns;
    private final int port;
    private HostState state;

    private Host(HostBuilder builder) {
        this.ipv4 = builder.ipv4;
        this.publicIp = builder.publicIp;
        this.state = builder.state;
        this.dns = builder.dns;
        this.port = builder.port;
    }

    /** Returns a string value of the ipv4 of a host */
    public String getIpv4() {
        return ipv4;
    }

    /** Returns a string value of the DNS of a host */
    public String getDns() {
        return dns;
    }

    /** Returns a string value of the port open of a host */
    public int getPort() {
        return port;
    }

    /** Returns a string value of the state of a host */
    public HostState getState() {
        return state;
    }

    /** Returns a string value of the subnet type of a host */
    public String getSubnet() {
        return publicIp ? "public" : "private";
    }

    /** Returns a boolean value to determine whether the host has a public ip */
    public boolean isPublicIp() {
        return publicIp;
    }

    public void setState(String state) {
        this.state = new HostStateFactory().hostState(state);
    }

    public boolean isActive() {
        return this.getState().toString().equals("active");
    }

    /** Overrides the toString method for this object */
    @Override
    public String toString() {
        return new StringBuilder(this.getIpv4())
            .append(",").append(this.getDns())
            .append(",").append(this.getPort())
            .append(",").append(this.getState())
            .append(",").append(this.getSubnet())
            .append("\n").toString();
    }

    public static class HostBuilder {
        private final String ipv4;
        private final boolean publicIp;
        private String dns;
        private HostState state;
        private int port;

        public HostBuilder(String ipv4) {
            this.ipv4 = ipv4;
            this.publicIp = isPublicIp(ipv4);
        }

        public HostBuilder withDns(String dns) {
            this.dns = dns;
            return this;
        }

        public HostBuilder withPort(int port) {
            this.port = port;
            return this;
        }

        public HostBuilder withState(String state) {
            this.state = new HostStateFactory().hostState(state);
            return this;
        }

        public Host build() {
            return new Host(this);
        }

        // TODO Add regex to check for private/public. Defaulting to private for now
        private boolean isPublicIp(String ipv4) {
            return false;
        }
    }
}
