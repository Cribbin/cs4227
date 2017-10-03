package fleetManager.command;

import fleetManager.FleetManagerImplementation;
import fleetManager.hosts.Host;

import java.util.List;

public class GetHostsCommand implements Command {
    private FleetManagerImplementation fleetManagerImplementation;
    private List<Host> hosts;

    public GetHostsCommand(){
        fleetManagerImplementation =new FleetManagerImplementation();
    }

    public void execute() {
        hosts=fleetManagerImplementation.getHosts();
    }
}