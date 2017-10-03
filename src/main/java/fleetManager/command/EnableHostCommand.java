package fleetManager.command;

import fleetManager.FleetManager;
import fleetManager.hosts.Host;
import fleetManager.FleetManagerImplementation;

public class EnableHostCommand implements Command {
    private Host host;
    private FleetManager fleetManagerImplementation;

    public EnableHostCommand(Host host){
        fleetManagerImplementation =new FleetManagerImplementation();
        this.host=host;
    }

    public void execute() {
        fleetManagerImplementation.enableHost(host);
    }

}
