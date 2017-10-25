package requestManagement.fleetManager.healthCheck;

/**
 * Handles health checks to the fleet
 *
 * An implementation of this class will run health checks on the fleet
 * and can then instruct the fleet manager to disable, enable, remove or add hosts depending on the results.
 */
public interface HealthCheck {
    /** Runs a health check for the fleet */
    void runHealthCheck();
}
