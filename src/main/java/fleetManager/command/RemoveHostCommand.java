package fleetManager.command;

import fleetManager.FleetManager;
import fleetManager.hosts.Host;
import fleetManager.FleetManagerImplementation;

public class RemoveHostCommand implements Command {
    private Host host;
    private FleetManager fleetManagerImplementation;

    public RemoveHostCommand(Host host){
        fleetManagerImplementation =new FleetManagerImplementation();
        this.host=host;
    }

    public void execute() {
        fleetManagerImplementation.removeHost(host);
    }
}
