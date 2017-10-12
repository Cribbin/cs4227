package requestManagement.fleetManager;

import requestManagement.fleetManager.hosts.Host;
import requestManagement.fleetManager.storage.DAOFactory;
import requestManagement.fleetManager.storage.HostDAO;

import java.util.List;

/**
 * Handles fleet management
 *
 * This singleton class interfaces with a HostDAO to update the storage system
 * and it will be used to access the various hosts.
 */
public class FleetManager {

    private static FleetManager fleetManagerInstance = null;
    private HostDAO hostDataAccess;

    private FleetManager() {
        hostDataAccess = new DAOFactory().getDAO();
    }

    /** Requests for a host to be added */
    public void addHost(Host host) {
        hostDataAccess.addHost(host);
    }

    /** Requests for a host to be removed */
    public void removeHost(Host host) {
        hostDataAccess.removeHost(host);
    }

    /** Requests for a host to be enabled */
    public void enableHost(Host host) {
        hostDataAccess.enableHost(host);
    }

    /** Requests for a host to be disabled */
    public void disableHost(Host host) {
        hostDataAccess.disableHost(host);
    }

    /** Returns a List of Hosts from the HostDAO object */
    public List<Host> getHosts() {
        return hostDataAccess.getHosts();
    }

    /** Returns the instance of the Singleton class and initialises it if not already initialised */
    public static FleetManager getInstance() {
        if (fleetManagerInstance == null) {
            fleetManagerInstance = new FleetManager();
        }
        return fleetManagerInstance;
    }
}
