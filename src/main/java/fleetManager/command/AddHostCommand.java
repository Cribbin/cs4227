package fleetManager.command;

import fleetManager.hosts.Host;
import fleetManager.FleetManagerImplementation;

public class AddHostCommand implements Command{
    private Host host;
    private FleetManagerImplementation fleetManagerImplementation;
    public AddHostCommand(Host host){
        fleetManagerImplementation =new FleetManagerImplementation();
        this.host=host;
    }

    public void execute(){
        fleetManagerImplementation.addHost(host);
    }

}
