package requestManagement.fleetManager.healthCheck;

import requestManagement.fleetManager.FleetManager;

public class HealthCheckImplementation implements HealthCheck {
    private FleetManager fleetManager;

    public HealthCheckImplementation(FleetManager fleetManager) {
        this.fleetManager = fleetManager;
    }

    public void execute(HealthCheckStrategy strategy, long refreshInterval) {
        Runnable task = () -> performHealthCheck(strategy, refreshInterval);
        new Thread(task).start();
    }

    private void performHealthCheck(HealthCheckStrategy strategy, long refreshInterval) {
        while (true) {
            strategy.runHealthCheck(this.fleetManager);

            if (fleetManager.getNumActiveHosts() < 2) {
                // Add new host(s)
            }

            try {
                Thread.sleep(refreshInterval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                break;
            }
        }
    }
}
