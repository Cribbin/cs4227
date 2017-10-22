package requestManagement.fleetManager;

import requestManagement.fleetManager.hosts.Host;
import java.net.InetAddress;

public class HealthCheckImplementation implements HealthCheck {
    private FleetManager fleetManager;

    public HealthCheckImplementation(FleetManager fleetManager) {
        this.fleetManager = fleetManager;
    }

    @Override
    public void runHealthCheck() {
        fleetManager.getHosts().forEach(this::individualHealthCheck);
    }

    private void individualHealthCheck(Host host) {
        String ip = host.getIpv4();
        try {
            InetAddress inetAddress = InetAddress.getByName(ip);

            host.setState(inetAddress.isReachable(5000) ? "active" : "inactive");

        } catch (Exception ex) {
            System.out.println("Exception:" + ex.getMessage());
            host.setState("inactive");
        }
    }
}
