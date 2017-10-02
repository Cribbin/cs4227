package fleetManager.command;

import fleetManager.hosts.Host;
import fleetManager.hosts.HostManager;

public class DisableHostCommand implements Command {
    private Host host;
    private HostManager hostManager;

    DisableHostCommand(Host host){
        hostManager=new HostManager();
        this.host=host;
    }

    public void execute(){
        hostManager.disableHost(host);
    }
}
