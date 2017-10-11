package requestManagement.fleetManager.storage;

import requestManagement.fleetManager.hosts.Host;

import java.util.List;

/**
 * Object to interface with the storage system implemented ie. csv file
 * An implementation of this we directly read and write from a storage system.
 */
public interface HostDAO {
    /** Adds a new Host to the storage system */
    void addHost(Host host);

    /** Removes a Host from the storage system */
    void removeHost(Host host);

    /** Sets the Host to an active state in the storage system */
    void enableHost(Host host);

    /** Sets the Host to an inactive state in the storage system */
    void disableHost(Host host);

    /** Returns a List of Hosts from the Storage System */
    List<Host> getHosts();
}
