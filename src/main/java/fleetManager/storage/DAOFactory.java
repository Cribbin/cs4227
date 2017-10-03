package fleetManager.storage;

public class DAOFactory {

    public HostDAO getDAO(){
        return new HostDAOFileSystem();
    }
}
