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
    private final String port;
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
    public String getDNS() {
        return dns;
    }

    /** Returns a string value of the port open of a host */
    public String getPort() {
        return port;
    }

    /** Returns a string value of the state of a host */
    public String getState() {
        return this.state.toString();
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

    /** Overrides the toString method for this object */
    @Override
    public String toString() {
        return this.getIpv4() + "," + this.getDNS() + "," + this.getPort() + "," + this.getState() + "," + this.getSubnet();
    }

    public static class HostBuilder {
        private static final String publicIpRegex = "(^127\\.)|(^10\\.)|(^172\\.1[6-9]\\.)|(^172\\.2[0-9]\\.)|(^172\\.3[0-1]\\.)|(^192\\.168\\.)";

        private final String ipv4;
        private final boolean publicIp;
        private String dns;
        private HostState state;
        private String port;

        public HostBuilder(String ipv4) {
            this.ipv4 = ipv4;
            this.publicIp = !ipv4.matches(publicIpRegex);
        }

        public HostBuilder withDns(String dns) {
            this.dns = dns;
            return this;
        }

        public HostBuilder withPort(String port) {
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
    }
}
