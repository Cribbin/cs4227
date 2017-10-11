package requestManagement.fleetManager.storage;

/**
 * Returns a DAO object.
 *
 * This factory is used to return a DAO object so that the FleetManager does not need
 * to know what data source the system is using.
 * This way we can easily implement other storage types without affecting then FleetManagers code.
 */
public class DAOFactory {

    public DAOFactory() {}

    /** Returns a HostDAO implementation for data access */
    public HostDAO getDAO() {
        return new HostDAOFileSystem();
    }
}
