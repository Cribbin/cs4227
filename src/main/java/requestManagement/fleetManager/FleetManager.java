package requestManagement.fleetManager;

import requestManagement.fleetManager.hosts.Host;
import requestManagement.fleetManager.storage.DAOFactory;
import requestManagement.fleetManager.storage.HostDAO;

import java.util.List;

public class FleetManager {

    private static FleetManager fleetManagerInstance = null;
    private HostDAO hostDataAccess;

    private FleetManager() {
        hostDataAccess = new DAOFactory().getDAO();
    }

    public void addHost(Host host) {
        hostDataAccess.addHost(host);
    }

    public void removeHost(Host host) {
        hostDataAccess.removeHost(host);
    }

    public void enableHost(Host host) {
        hostDataAccess.enableHost(host);
    }

    public void disableHost(Host host) {
        hostDataAccess.disableHost(host);
    }

    public List<Host> getHosts() {
        return hostDataAccess.getHosts();
    }

    public static FleetManager getInstance() {
        if (fleetManagerInstance == null) {
            fleetManagerInstance = new FleetManager();
        }
        return fleetManagerInstance;
    }
}
