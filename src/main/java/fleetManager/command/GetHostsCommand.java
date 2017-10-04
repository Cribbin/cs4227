package fleetManager.command;

import fleetManager.FleetManager;
import fleetManager.FleetManagerImplementation;
import fleetManager.hosts.Host;

import java.util.List;

public class GetHostsCommand implements Command {
    private FleetManager fleetManagerImplementation;
    private List<Host> hosts;

    public GetHostsCommand(){
        fleetManagerImplementation =new FleetManagerImplementation();
    }

    public void execute() {
        hosts=fleetManagerImplementation.getHosts();
    }

    public List<Host> getHosts(){
        return hosts;
    }
}