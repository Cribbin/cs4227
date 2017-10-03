package fleetManager.command;

import fleetManager.hosts.Host;
import fleetManager.FleetManagerImplementation;

public class EnableHostCommand implements Command {
    private Host host;
    private FleetManagerImplementation fleetManagerImplementation;

    public EnableHostCommand(Host host){
        fleetManagerImplementation =new FleetManagerImplementation();
        this.host=host;
    }

    public void execute() {
        fleetManagerImplementation.enableHost(host);
    }

}
