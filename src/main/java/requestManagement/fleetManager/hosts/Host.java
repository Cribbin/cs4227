package requestManagement.fleetManager.hosts;

/**
 * Defines a Host object
 *
 * This object can be created by data from the storage system or possibly by user input in the future.
 */
public class Host {
    private final String ipv4;
    private final String dns;
    private final int port;
    private final int maxConnections;
    private int activeConnections;
    private HostState state;

    private Host(HostBuilder builder) {
        this.ipv4 = builder.ipv4;
        this.state = builder.state;
        this.dns = builder.dns;
        this.port = builder.port;
        this.maxConnections = builder.maxConnections;
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

    /** Returns a int value of max connections for a host */
    public int getMaxConnections() {
        return maxConnections;
    }

    /** Returns an int value of active connection for a host */
    public int getActiveConnections() {
        return activeConnections;
    }

    /** Returns a string value of the state of a host */
    public HostState getState() {
        return state;
    }

    public void setState(String state) {
        this.state = new HostStateFactory().hostState(state);
    }

    public boolean isActive() {
        return this.getState().toString().equals("active");
    }
    
    public void setActiveConnections(int activeConnections) {
        this.activeConnections = activeConnections;
    }

    /** Overrides the toString method for this object */
    @Override
    public String toString() {
        return new StringBuilder(this.getIpv4())
            .append(",").append(this.getDns())
            .append(",").append(this.getPort())
            .append(",").append(this.getState())
            .append(",").append(this.getMaxConnections())
            .append("\n").toString();
    }

    public static class HostBuilder {
        private final String ipv4;
        private String dns;
        private HostState state;
        private int port;
        private int maxConnections;

        public HostBuilder(String ipv4) {
            this.ipv4 = ipv4;
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

        public HostBuilder withMaxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
            return this;
        }

        public Host build() {
            return new Host(this);
        }

    }
}
