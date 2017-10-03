package fleetManager;

import fleetManager.hosts.Host;
import fleetManager.storage.DAOFactory;
import fleetManager.storage.HostDAO;

import java.util.ArrayList;
import java.util.List;

public class FleetManagerImplementation implements FleetManager {
//singleton
    private HostDAO hostDataAccess;

    public FleetManagerImplementation(){
        hostDataAccess= new DAOFactory().getDAO();
    }

    public void addHost(Host host){

    }

    public void removeHost(Host host){

    }

    public void enableHost(Host host){

    }

    public void disableHost(Host host){

    }

    public List<Host> getHosts(){
        return hostDataAccess.getHosts();
    }
}
