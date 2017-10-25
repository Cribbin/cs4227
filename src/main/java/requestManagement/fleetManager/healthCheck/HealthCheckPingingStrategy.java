package requestManagement.fleetManager.healthCheck;

import requestManagement.fleetManager.FleetManager;
import requestManagement.fleetManager.hosts.Host;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HealthCheckPingingStrategy implements HealthCheckStrategy {
    @Override
    public void runHealthCheck(FleetManager fleetManager) {
        fleetManager.getHosts().forEach(h -> individualHealthCheck(fleetManager, h));
    }

    private void individualHealthCheck(FleetManager fleetManager, Host host) {
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
