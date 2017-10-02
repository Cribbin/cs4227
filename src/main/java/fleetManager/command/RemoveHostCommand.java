package fleetManager.command;

import fleetManager.hosts.Host;
import fleetManager.hosts.HostManager;

public class RemoveHostCommand implements Command {
    private Host host;
    private HostManager hostManager;

    RemoveHostCommand(Host host){
        hostManager=new HostManager();
        this.host=host;
    }

    public void execute() {
        hostManager.removeHost(host);
    }
}
