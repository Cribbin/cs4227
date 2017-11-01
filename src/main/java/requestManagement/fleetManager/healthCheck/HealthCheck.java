package requestManagement.fleetManager.healthCheck;

/**
 * Handles health checks to the fleet
 *
 * An implementation of this class will run health checks on the fleet
 * and can then instruct the fleet manager to disable, enable, remove or add hosts depending on the results.
 */
public interface HealthCheck {
    /**
     * Execute the health check strategy and monitor fleet health
     * @param healthCheckStrategy The strategy to check the fleet health
     * @param refreshInterval The duration the thread sleeps in between each health check in milliseconds
     */
    void execute(HealthCheckStrategy healthCheckStrategy, long refreshInterval);
}
