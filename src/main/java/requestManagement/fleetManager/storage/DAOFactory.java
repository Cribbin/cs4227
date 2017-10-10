package requestManagement.fleetManager.storage;

public class DAOFactory {

    public DAOFactory() {}

    public HostDAO getDAO() {
        return new HostDAOFileSystem();
    }
}
