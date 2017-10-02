package fleetManager.command;

import fleetManager.hosts.Host;
import fleetManager.hosts.HostManager;

public class EnableHostCommand implements Command {
    private Host host;
    private HostManager hostManager;

    public EnableHostCommand(Host host){
        hostManager=new HostManager();
        this.host=host;
    }

    public void execute() {
        hostManager.enableHost(host);
    }

}
