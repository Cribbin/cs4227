package fleetManager.command;

import fleetManager.FleetManager;
import fleetManager.hosts.Host;
import fleetManager.FleetManagerImplementation;

public class DisableHostCommand implements Command {
    private Host host;
    private FleetManager fleetManagerImplementation;

    public DisableHostCommand(Host host){
        fleetManagerImplementation =new FleetManagerImplementation();
        this.host=host;
    }

    public void execute(){
        fleetManagerImplementation.disableHost(host);
    }
}
