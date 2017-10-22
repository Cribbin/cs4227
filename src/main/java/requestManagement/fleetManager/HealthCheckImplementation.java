package requestManagement.fleetManager;

import requestManagement.fleetManager.hosts.Host;
import java.net.InetAddress;
import java.net.UnknownHostException;

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
        final int fiveSecondTimeout = 5000;
        final String ip = host.getIpv4();

        try {
            InetAddress inetAddress = InetAddress.getByName(ip);

            if (inetAddress.isReachable(fiveSecondTimeout)) {
                fleetManager.enableHost(host);
            } else {
                fleetManager.disableHost(host);
            }

        } catch (UnknownHostException ex) {
            System.out.println(String.format("Exception: %s", ex.getMessage()));
            fleetManager.disableHost(host);
        } catch (Exception ex) {
            System.out.println(String.format("Exception: %s", ex.getMessage()));
        }
    }
}
