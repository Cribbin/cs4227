package requestManagement.fleetManager.healthCheck;

import requestManagement.fleetManager.FleetManager;

/**
 * Defines the strategy to use in a health check for the fleet.
 */
public interface HealthCheckStrategy {
    /** Runs a health check for the fleet */
    void runHealthCheck(FleetManager fleetManager);
}
