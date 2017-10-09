package requestManagement.fleetManager;

import requestManagement.fleetManager.hosts.Host;
import requestManagement.fleetManager.storage.DAOFactory;
import requestManagement.fleetManager.storage.HostDAO;

import java.util.List;

public class FleetManagerImplementation implements FleetManager {

    private static FleetManager fleetManagerInstance= null;
    private HostDAO hostDataAccess;

    private FleetManagerImplementation(){
        hostDataAccess= new DAOFactory().getDAO();
    }

    @Override
    public void addHost(Host host){
        hostDataAccess.addHost(host);
    }

    @Override
    public void removeHost(Host host){
        hostDataAccess.removeHost(host);
    }

    @Override
    public void enableHost(Host host){
        hostDataAccess.enableHost(host);
    }

    @Override
    public void disableHost(Host host){
        hostDataAccess.disableHost(host);
    }

    @Override
    public List<Host> getHosts(){
        return hostDataAccess.getHosts();
    }

    public static FleetManager getInstance(){
        if(fleetManagerInstance == null){
            fleetManagerInstance=new FleetManagerImplementation();
        }
        return fleetManagerInstance;
    }

    public void test(){}
}
